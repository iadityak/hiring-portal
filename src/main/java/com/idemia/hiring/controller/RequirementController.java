package com.idemia.hiring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idemia.hiring.dto.RequirementDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.Requirement;
import com.idemia.hiring.service.RequirementService;

@RestController
@RequestMapping("/api/requirement")
@CrossOrigin
public class RequirementController {
	
	@Autowired
	private RequirementService requirementService;
	
	@PostMapping("/add")
	public void addRequirements(@RequestBody RequirementDTO requirementDTO) {
		requirementService.addRequirement(requirementDTO);
	}
	
	@GetMapping("/get/all")
	public List<Requirement> getAllRequirements() {
		return requirementService.getAllRequirements();
	}
	
	@GetMapping("/get/{RquisitionId}")
	public List<Candidate> getCandidatesForRequirement(@PathVariable(value="RquisitionId",required=true) String requisitionId){
		return requirementService.getCandidatesFroRequirements(requisitionId);
		
	}
}