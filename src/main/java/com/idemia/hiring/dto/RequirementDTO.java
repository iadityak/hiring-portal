package com.idemia.hiring.dto;

import java.util.Date;

public class RequirementDTO {

	private String requisitionId;
	private Date dateOfOpening;
	private String position;
	private String domain;
	private String subDomain;
	private String reportingManager;
	private String jobDescription;
	private String jobStatus;
	private Date dateOfSelection;
	
	public Date getDateOfOpening() {
		return dateOfOpening;
	}
	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getSubDomain() {
		return subDomain;
	}
	public void setSubDomain(String subDomain) {
		this.subDomain = subDomain;
	}
	public String getReportingManager() {
		return reportingManager;
	}
	public void setReportingManager(String reportingManager) {
		this.reportingManager = reportingManager;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public Date getDateOfSelection() {
		return dateOfSelection;
	}
	public void setDateOfSelection(Date dateOfSelection) {
		this.dateOfSelection = dateOfSelection;
	}
}
