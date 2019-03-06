package com.idemia.hiring.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

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
		Interview interview = objectMapper.convertToInterviewEntity(interviewDTO);
		Candidate candidate = candidateRepository.findByPanCard(interviewDTO.getCandidatePanCard());
		if(candidate!=null){
			interview.setCandidate(candidate);
			candidate.getInterview().add(interview);
			interviewRepository.save(interview);
			candidateRepository.save(candidate);
		}
		else{
			throw new CandidateException("Candidate doesn't exist");
		}
	}

	@Override
	public List<Interview> getAllInterview(String panCard) {
		return interviewRepository.findByCandidatePanCard(panCard);

	}

}
