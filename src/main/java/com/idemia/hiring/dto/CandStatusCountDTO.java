package com.idemia.hiring.dto;

/**
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         Contains candidate status count used while displaying Candidate
 *         information in the form of PIE chart on Hiring Portal DASHBOARD.
 *
 */
public class CandStatusCountDTO {

	private Integer selectedCount = new Integer(0);
	private Integer rejectedCount = new Integer(0);
	private Integer interviewedCount = new Integer(0);

	public Integer getSelectedCount() {
		return selectedCount;
	}

	public void setSelectedCount(Integer selectedCount) {
		this.selectedCount = selectedCount;
	}

	public Integer getRejectedCount() {
		return rejectedCount;
	}

	public void setRejectedCount(Integer rejectedCount) {
		this.rejectedCount = rejectedCount;
	}

	public Integer getInterviewedCount() {
		return interviewedCount;
	}

	public void setInterviewedCount(Integer interviewedCount) {
		this.interviewedCount = interviewedCount;
	}

}
