package com.idemia.hiring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idemia.hiring.dto.CandidateDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.service.CandidateService;

@RestController
@RequestMapping("/api/candidate")
@CrossOrigin
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@PostMapping("/add")
	public void addCandidate(@RequestBody CandidateDTO candidateDTO) {
		candidateService.addCandidate(candidateDTO);
	}
	
	@GetMapping("/get/all")
	public List<Candidate> allCandidates(){
		return candidateService.allCandidates();
	}
	
	@GetMapping("/get/{pancard}")
	public Candidate getCandidateByPan(@PathVariable(value = "pancard", required = true) String panCard){
		return candidateService.findCandidatebyPan(panCard);
	}
	
	@PutMapping("/update/{pancard}")
	public void updateCandidate(@PathVariable(value="pancard",required=true) String panCard, @RequestBody CandidateDTO candidateDTO) {
		candidateService.updateCandidate(candidateDTO, panCard);
	}
}
