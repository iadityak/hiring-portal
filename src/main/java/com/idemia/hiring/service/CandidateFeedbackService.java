package com.idemia.hiring.service;

import org.springframework.web.servlet.ModelAndView;

import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.CandidateFeedback;

/***
 * 
 * 
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         Service object for domain model class CandidateFeedback.
 * 
 * @see com.idemia.hiring.entity.CandidateFeedback
 */
public interface CandidateFeedbackService {

	CandidateFeedback createCandFeedback(CandidateFeedback candidateFeedback);

	void sendEmailForCandFeedback(Integer interviewId);

	void createCandidateFeedbackMail(Candidate fetchedCandidate, String subject, String jwtToken);

	void returnFeedbackForm(String jwtToken, ModelAndView modelAndView);

	void submitFeedback(Integer interviewId, String comments, String rate);

}
