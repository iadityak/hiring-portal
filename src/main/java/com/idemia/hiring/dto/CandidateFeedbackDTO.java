package com.idemia.hiring.dto;

/**
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         Contains feedback information submitted by Candidate for a particular
 *         interview round.
 *
 */
public class CandidateFeedbackDTO {

	private Integer interviewId;
	private String comments;
	private String rating;

	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}
