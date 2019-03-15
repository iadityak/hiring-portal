package com.idemia.hiring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.idemia.hiring.exception.CandidateException;
import com.idemia.hiring.service.CandidateFeedbackService;

/**
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         Controller object for dealing with CandidateFeedback.
 */
@RestController
@RequestMapping("/api/candidate/feedback")
public class CandidateFeedbackController {

	@Autowired
	private CandidateFeedbackService candidateFeedbackService;

	@PostMapping("/submitfeedback")
	public void submitFeedback(@ModelAttribute("interviewid") Integer interviewId,
			@ModelAttribute("comments") String comments, @ModelAttribute("rate") String rate) {
		candidateFeedbackService.submitFeedback(interviewId, comments, rate);
	}

	@GetMapping("/sendemail/{interviewid}")
	public void sendEmailForCandFeedback(@PathVariable("interviewid") Integer interviewId) {
		if (interviewId != null && interviewId != 0)
			candidateFeedbackService.sendEmailForCandFeedback(interviewId);
		else
			throw new CandidateException("Interview Id can not be null/0");

	}

	@GetMapping("/returnfeedbackform")
	public ModelAndView returnFeedbackForm(@RequestParam String jwtToken) {
		ModelAndView modelAndView = new ModelAndView("feedback");
		candidateFeedbackService.returnFeedbackForm(jwtToken, modelAndView);
		return modelAndView;
	}

}
