package com.idemia.hiring.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idemia.hiring.dto.RequirementDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.Requirement;
import com.idemia.hiring.exception.CandidateException;
import com.idemia.hiring.mapper.ObjectMapper;
import com.idemia.hiring.repository.RequirementRepository;
import com.idemia.hiring.service.RequirementService;

@Service
public class RequirementServiceImpl implements RequirementService {

	@Autowired
	private RequirementRepository requirementRepository;
	
	@Autowired
	private ObjectMapper objectMapper;

	
	@Override
	public void addRequirement(RequirementDTO requirementDTO) {
		Requirement requirement = new Requirement();
		requirement = objectMapper.convertToRequirementEntity(requirementDTO);
		requirementRepository.save(requirement);
	}


	@Override
	public List<Requirement> getAllRequirements() {
		return requirementRepository.findAll();
	}


	@Override
	public List<Candidate> getCandidatesFroRequirements(String requisitionId) {
		Requirement requirement = requirementRepository.findByRequisitionId(requisitionId) ;
		List<Candidate> candidate = requirement.getCandidate();
		if(candidate!=null) {
			return candidate;
		}
		else
			throw new CandidateException("No Candidate exist for this Requirement");
	}

}
