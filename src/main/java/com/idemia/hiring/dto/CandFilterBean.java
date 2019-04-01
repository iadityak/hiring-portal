package com.idemia.hiring.dto;

/**
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         Contains filter used to get specific Candidates.
 *
 */
public class CandFilterBean {

	private String startDate;
	private String endDate;
	private String candStatus;
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCandStatus() {
		return candStatus;
	}

	public void setCandStatus(String candStatus) {
		this.candStatus = candStatus;
	}

}
