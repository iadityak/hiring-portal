package com.idemia.hiring.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 *@author G521774 (aditya.kumar@idemia.com)
 *  
 */
@Entity
@Table(name="requirement")
public class Requirement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(unique=true)
	private String requisitionId;
	private Date dateOfOpening;
	private String position;
	private String domain;
	private String subDomain;
	private String reportingManager;
	private String jobDescription;
	private String jobStatus;
	private String selectedCandidate;
	private String dateOfSelection;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "requirement")
	@JsonIgnore
	private final List<Candidate> candidate = new ArrayList<>();

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

	public String getSelectedCandidate() {
		return selectedCandidate;
	}

	public void setSelectedCandidate(String selectedCandidate) {
		this.selectedCandidate = selectedCandidate;
	}

	public List<Candidate> getCandidate() {
		return candidate;
	}


	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getDateOfSelection() {
		return dateOfSelection;
	}

	public void setDateOfSelection(String dateOfSelection) {
		this.dateOfSelection = dateOfSelection;
	}

	public String getRequisitionId() {
		return requisitionId;
	}

	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}

	@Override
	public String toString() {
		return "Requirement [id=" + id + ", requisitionId=" + requisitionId + ", dateOfOpening=" + dateOfOpening
				+ ", position=" + position + ", domain=" + domain + ", subDomain=" + subDomain + ", reportingManager="
				+ reportingManager + ", jobDescription=" + jobDescription + ", jobStatus=" + jobStatus
				+ ", selectedCandidate=" + selectedCandidate + ", dateOfSelection=" + dateOfSelection + ", candidate="
				+ candidate + "]";
	}

}
