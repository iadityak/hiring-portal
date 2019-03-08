package com.idemia.hiring.service.Impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
@Transactional
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private RequirementRepository requirementRepository;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	@Transactional
	public void addCandidate(CandidateDTO candidateDTO) {
		Candidate candidate = objectMapper.convertToCandidateEntity(candidateDTO);
		Requirement requirement = requirementRepository.findByRequisitionId(candidateDTO.getRequisitionId());
		if (requirement!=null) {
			candidate.setRequirement(requirement);
			requirement.getCandidate().add(candidate);
			candidateRepository.save(candidate);
			
		}
		else
			throw new CandidateException("Requirement doesn't exist");
	}

	@Override
	public List<Candidate> allCandidates() {
		return candidateRepository.findAll(sortCandidatesByIdDesc());
	}

	@Override
	public Candidate findCandidatebyPan(String panCard) {
		Candidate candidate = candidateRepository.findByPanCard(panCard);
		if (candidate!=null) {
			return candidate;
		}
		else
			throw new CandidateException("Candidate doesn't exist");
	}

	@Override
	public void updateCandidate(CandidateDTO candidateDTO,String panCard ) {
		Candidate can = candidateRepository.findByPanCard(panCard);
		if(can!=null){
			 	Candidate candidate = objectMapper.convertToCandidateEntity(candidateDTO);
				candidateRepository.save(candidate);
			}
		else
			throw new CandidateException("UPDATE FAIL. Candidate doesn't exist");
	}
	
	public boolean candidateExistsByPan(String pan) {
		return candidateRepository.existsByPanCard(pan);
	}

	private Sort sortCandidatesByIdDesc() {
		return new Sort(Sort.Direction.DESC, "candidateId");
	}
	

}
