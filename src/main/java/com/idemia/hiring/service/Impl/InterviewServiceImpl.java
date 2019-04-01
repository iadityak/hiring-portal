package com.idemia.hiring.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idemia.hiring.dto.InterviewDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.Interview;
import com.idemia.hiring.exception.CandidateException;
import com.idemia.hiring.mapper.ObjectMapper;
import com.idemia.hiring.repository.CandidateRepository;
import com.idemia.hiring.repository.InterviewRepository;
import com.idemia.hiring.service.InterviewService;

@Service
public class InterviewServiceImpl implements InterviewService {

	@Autowired
	private InterviewRepository interviewRepository;
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	@Transactional
	public void addInterview(InterviewDTO interviewDTO) {
		Candidate candidate = candidateRepository.findByPhoneNumber(interviewDTO.getCandPhoneNumber());
		if(candidate!=null){
			Interview interview = objectMapper.convertToInterviewEntity(interviewDTO);
			interview.setCandidate(candidate);
			candidate.getInterview().add(interview);
			candidate.setStatus(interviewDTO.getRoundStatus());
			interviewRepository.save(interview);
			candidateRepository.save(candidate);
		}
		else{
			throw new CandidateException("Candidate doesn't exist");
		}
	}

	@Override
	@Transactional
	public List<Interview> getAllInterview(String panCard) {
		Candidate candidate = candidateRepository.findByPhoneNumber(panCard);
		if(candidate!=null) {
			Hibernate.initialize(candidate.getInterview());
			List<Interview> interview = candidate.getInterview();
			if(interview!=null) {
				return interview;
			}
			else
				throw new CandidateException("No Interview Rounds Exists for this Candidate");
		}
		else
			throw new CandidateException("Candidate doesn't exist");

	}

	@Override
	public Interview findByInterviewId(Integer interviewId) {
		return interviewRepository.findByInterviewId(interviewId);
	}

}
