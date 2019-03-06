package com.idemia.hiring.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idemia.hiring.dto.CandidateDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.Requirement;
import com.idemia.hiring.exception.CandidateException;
import com.idemia.hiring.mapper.ObjectMapper;
import com.idemia.hiring.repository.CandidateRepository;
import com.idemia.hiring.repository.RequirementRepository;
import com.idemia.hiring.service.CandidateService;

@Service
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private RequirementRepository requirementRepository;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public void addCandidate(CandidateDTO candidateDTO) {
		Candidate candidate = objectMapper.convertToCandidateEntity(candidateDTO);
		Requirement requirement = requirementRepository.findByRequisitionId(candidateDTO.getRequisitionId());
		if (requirement!=null) {
			candidate.setRequirement(requirement);
			requirement.getCandidate().add(candidate);
			requirementRepository.save(requirement);
			candidateRepository.save(candidate);
			
		}
		else
			throw new CandidateException("Requirement doesn't exist");
	}

	@Override
	public List<Candidate> allCandidates() {
		return candidateRepository.findAll();
	}

	@Override
	public Candidate findCandidatebyPan(String panCard) {
		return candidateRepository.findById(panCard).get();
	}

	@Override
	public void updateCandidate(CandidateDTO candidateDTO) {
		if(candidateRepository.existsById(candidateDTO.getPanCard())){
			 	Candidate candidate = objectMapper.convertToCandidateEntity(candidateDTO);
				candidateRepository.save(candidate);
			}
		else
			throw new CandidateException("UPDATE FAIL. Candidate doesn't exist");
	}

}
