package com.idemia.hiring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idemia.hiring.dto.InterviewDTO;
import com.idemia.hiring.entity.Interview;
import com.idemia.hiring.service.InterviewService;


@RestController
@RequestMapping("/api/intevriew")
@CrossOrigin
public class InterviewController {
	
	@Autowired
	private InterviewService interviewService;
	
	@PostMapping("/add")
	public void addCandidate(@RequestBody InterviewDTO interviewDTO) {
		interviewService.addInterview(interviewDTO);
	}
	
	@GetMapping("/get/all/{pancard}")
	public List<Interview> getInterveiw(@PathVariable(value = "pancard", required = true) String panCard){
		return interviewService.getAllInterview(panCard);
	}
	

}
