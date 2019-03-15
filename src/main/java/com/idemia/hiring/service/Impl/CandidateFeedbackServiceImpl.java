package com.idemia.hiring.service.Impl;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.idemia.hiring.constants.AppConstants;
import com.idemia.hiring.dto.CandidateFeedbackDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.CandidateFeedback;
import com.idemia.hiring.entity.Interview;
import com.idemia.hiring.enums.RatingEnum;
import com.idemia.hiring.exception.AppError;
import com.idemia.hiring.exception.CandidateException;
import com.idemia.hiring.repository.CandidateFeedbackRepository;
import com.idemia.hiring.service.CandidateFeedbackService;
import com.idemia.hiring.service.InterviewService;
import com.idemia.hiring.util.JsonWebTokenUtility;

import io.jsonwebtoken.Claims;

/***
 * 
 * 
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         ServiceImpl object for domain model class CandidateFeedback.
 * 
 * @see com.idemia.hiring.entity.CandidateFeedback
 */
@Service
public class CandidateFeedbackServiceImpl implements CandidateFeedbackService {

	@Autowired
	public JavaMailSender emailSender;
	@Autowired
	private InterviewService interviewService;

	@Autowired
	private JsonWebTokenUtility jsonWebTokenUtility;

	@Autowired
	private CandidateFeedbackRepository candidateFeedbackRepository;

	@Override
	public CandidateFeedback createCandFeedback(CandidateFeedback candidateFeedback) {
		CandidateFeedback savedEntity = candidateFeedbackRepository.saveAndFlush(candidateFeedback);
		if (savedEntity.getCandFeedId() != null)
			return savedEntity;
		else
			throw new CandidateException(AppError.candFeedPersistError);

	}

	@Override
	public void sendEmailForCandFeedback(Integer interviewId) {
		Interview fetchedRound = interviewService.findByInterviewId(interviewId);
		if (fetchedRound != null) {
			Candidate fetchedCandidate = fetchedRound.getCandidate();
			if (fetchedCandidate != null) {
				if (fetchedCandidate.getEmail() != null && !fetchedCandidate.getEmail().isEmpty()) {
					if (fetchedCandidate.getRequirement().getPosition() != null
							&& !fetchedCandidate.getRequirement().getPosition().isEmpty()) {
						String jwtToken = jsonWebTokenUtility.createJwtToken(fetchedCandidate.getEmail(),
								AppConstants.jwtIssuer, fetchedRound.getInterviewId().toString(),
								fetchedCandidate.getCandidateId().toString());
						createCandidateFeedbackMail(fetchedCandidate, AppConstants.candFeedbackEmailSubject, jwtToken);
					} else
						throw new CandidateException(AppError.positionNotExists);

				} else
					throw new CandidateException(AppError.emailNotExists + fetchedCandidate.getFirstName());
			}
		}
	}

	@Override
	public void createCandidateFeedbackMail(Candidate fetchedCandidate, String subject, String jwtToken) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(fetchedCandidate.getEmail());
		message.setSubject(subject);
		message.setText((AppConstants.candFeedMailBody.replace("{name}", fetchedCandidate.getFirstName())
				.replace("{company}", AppConstants.comapnyName)
				.replace("{position}", fetchedCandidate.getRequirement().getPosition())) + ""
				+ AppConstants.localEnvBaseUrl + "" + AppConstants.returnFeedFormUrl + jwtToken);
		emailSender.send(message);

	}

	@Override
	public void returnFeedbackForm(String jwtToken, ModelAndView modelAndView) {
		Claims claims = jsonWebTokenUtility.decodeJwtToken(jwtToken);
		String interviewId = (String) claims.get("sub");
		modelAndView.addObject("interviewId", interviewId);
	}

	@Override
	public void submitFeedback(CandidateFeedbackDTO candidateFeedbackDTO) {
		CandidateFeedback candidateFeedback = new CandidateFeedback();
		candidateFeedback.setCandFeedComments(candidateFeedbackDTO.getComments());
		candidateFeedback.setCandFeedCreated(LocalDateTime.now());
		candidateFeedback.setCandFeedOverallRating(RatingEnum.valueOf(candidateFeedbackDTO.getRating()));
		Interview fetchedInterview = interviewService.findByInterviewId(candidateFeedbackDTO.getInterviewId());
		candidateFeedback.setCandFeedCandidate(fetchedInterview.getCandidate());
		candidateFeedback.setCandFeedRound(fetchedInterview);
		createCandFeedback(candidateFeedback);
	}
}
