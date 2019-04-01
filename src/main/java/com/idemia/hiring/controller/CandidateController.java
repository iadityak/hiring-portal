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
import com.idemia.hiring.exception.AppError;
import com.idemia.hiring.exception.CandidateException;
import com.idemia.hiring.service.CandidateService;

@RestController
@RequestMapping("/api/candidate")
@CrossOrigin
public class CandidateController {
	
	@Autowired
	private CandidateService candidateService;
	
	@PostMapping("/add")
	public void addCandidate(@RequestBody CandidateDTO candidateDTO) {
		if (candidateDTO.getPhoneNumber() != null && !candidateDTO.getPhoneNumber().isEmpty()) {
			if (!candidateService.isCandidateExistsByPhone(candidateDTO.getPhoneNumber()))
				candidateService.addCandidate(candidateDTO);
			else
				throw new CandidateException(AppError.candPhoneExists + candidateDTO.getPhoneNumber());
		} else
			throw new CandidateException(AppError.candPhoneEmpty);
	}
	
	@GetMapping("/get/all")
	public List<Candidate> allCandidates(){
		return candidateService.allCandidates();
	}
	
	@GetMapping("/get/{phone}")
	public Candidate getCandidateByPan(@PathVariable(value = "phone", required = true) String phoneNumber){
		return candidateService.findCandbyPhoneNumber(phoneNumber);
	}
	
	@PutMapping("/update/{phone}")
	public void updateCandidate(@PathVariable(value="phone",required=true) String phoneNumber, @RequestBody CandidateDTO candidateDTO) {
		candidateService.updateCandidate(candidateDTO, phoneNumber);
	}
	
	@GetMapping("/get-details/{phone}")
	public Candidate eagerGetCanidateByPan(@PathVariable(value = "phone", required = true) String phoneNumber) {
		return candidateService.eagerGetCandidateByPhone(phoneNumber);
	}
}
