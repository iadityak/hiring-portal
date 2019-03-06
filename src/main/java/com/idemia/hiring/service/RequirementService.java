package com.idemia.hiring.service;

import java.util.List;

import com.idemia.hiring.dto.RequirementDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.Requirement;


public interface RequirementService {

	void addRequirement(RequirementDTO requirementDTO);

	List<Requirement> getAllRequirements();

	List<Candidate> getCandidatesFroRequirements(String requisitionId);

}
