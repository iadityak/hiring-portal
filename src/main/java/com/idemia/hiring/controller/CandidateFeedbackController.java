package com.idemia.hiring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.idemia.hiring.dto.CandidateFeedbackDTO;
import com.idemia.hiring.exception.CandidateException;
import com.idemia.hiring.service.CandidateFeedbackService;
import com.idemia.hiring.util.JsonWebTokenUtility;

/**
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         Controller object for dealing with CandidateFeedback.
 */
@RestController
@RequestMapping("/api/candidate/feedback")
@CrossOrigin
public class CandidateFeedbackController {

	@Autowired
	private JsonWebTokenUtility jsonWebTokenUtility;
	
	@Autowired
	private CandidateFeedbackService candidateFeedbackService;

	@PostMapping("/submitfeedback")
	public ModelAndView submitFeedback(@ModelAttribute CandidateFeedbackDTO candidateFeedbackDTO) {
		ModelAndView modelAndView = new ModelAndView("thankyou");
		candidateFeedbackService.submitFeedback(candidateFeedbackDTO, modelAndView);
		return modelAndView;
	}

	@GetMapping("/sendemail/{interviewid}")
	public void sendEmailForCandFeedback(@PathVariable("interviewid") Integer interviewId,HttpServletRequest request) {
		if (interviewId != null && interviewId != 0)
			candidateFeedbackService.sendEmailForCandFeedback(interviewId, request);
		else
			throw new CandidateException("Interview Id can not be null/0");

	}

	@GetMapping("/returnfeedbackform")
	public ModelAndView returnFeedbackForm(@RequestParam String id) {
		ModelAndView modelAndView = new ModelAndView("feedback");
		boolean isTokenValid = jsonWebTokenUtility.isValidToken(id);
		if(isTokenValid) {
			candidateFeedbackService.returnFeedbackForm(id, modelAndView);
			return modelAndView;
	}else {
		
		ModelAndView modelAndView1 = new ModelAndView("pageError");
		return modelAndView1;
	}

	}
}
