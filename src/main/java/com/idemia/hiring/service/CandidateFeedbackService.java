package com.idemia.hiring.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

import com.idemia.hiring.dto.CandidateFeedbackDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.CandidateFeedback;

/***
 * 
 * 
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         Service object for domain model class CandidateFeedback.
 * 
 * @see com.idemia.hiring.entity.CandidateFeedback
 */
public interface CandidateFeedbackService {

	CandidateFeedback createCandFeedback(CandidateFeedback candidateFeedback);

	void sendEmailForCandFeedback(Integer interviewId, HttpServletRequest request);

	void createCandidateFeedbackMail(Candidate fetchedCandidate, String subject, String jwtToken,
			HttpServletRequest request);
	
	void returnFeedbackForm(String jwtToken, ModelAndView modelAndView);

	void submitFeedback(CandidateFeedbackDTO candidateFeedbackDTO);

}
