package com.idemia.hiring.dto;

import java.util.Date;

import com.idemia.hiring.enums.RatingEnum;

public class InterviewDTO {
	
	private int roundNumber;
	private Date dateOfInterview;
	private String candidatePanCard;
	private String interviewerName;
	private String interviewerComments;
	private String roundStatus;
	private RatingEnum domainLogic;
	private RatingEnum programming;
	private RatingEnum analysis;
	private RatingEnum designing;
	private RatingEnum integration;
	private RatingEnum process;
	private RatingEnum quality;
	private RatingEnum testing;
	private RatingEnum structuredTechniques;
	private RatingEnum documentation;
	private RatingEnum techSupport;
	private RatingEnum sysAdministration;
	private RatingEnum planningAndOrganizing;
	private RatingEnum scheduleManagement;
	private RatingEnum projectManagement;
	private RatingEnum projectEstimationSkills;
	private RatingEnum peopleManagement;
	private RatingEnum overallRating;
	private String reason;
	
	public int getRoundNumber() {
		return roundNumber;
	}
	public void setRoundNumber(int roundNumber) {
		this.roundNumber = roundNumber;
	}
	public Date getDateOfInterview() {
		return dateOfInterview;
	}
	public void setDateOfInterview(Date dateOfInterview) {
		this.dateOfInterview = dateOfInterview;
	}
	public String getInterviewerName() {
		return interviewerName;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public String getInterviewerComments() {
		return interviewerComments;
	}
	public void setInterviewerComments(String interviewerComments) {
		this.interviewerComments = interviewerComments;
	}
	public String getRoundStatus() {
		return roundStatus;
	}
	public void setRoundStatus(String roundStatus) {
		this.roundStatus = roundStatus;
	}
	public String getCandidatePanCard() {
		return candidatePanCard;
	}
	public void setCandidatePanCard(String candidatePanCard) {
		this.candidatePanCard = candidatePanCard;
	}
	public RatingEnum getDomainLogic() {
		return domainLogic;
	}
	public void setDomainLogic(RatingEnum domainLogic) {
		this.domainLogic = domainLogic;
	}
	public RatingEnum getProgramming() {
		return programming;
	}
	public void setProgramming(RatingEnum programming) {
		this.programming = programming;
	}
	public RatingEnum getAnalysis() {
		return analysis;
	}
	public void setAnalysis(RatingEnum analysis) {
		this.analysis = analysis;
	}
	public RatingEnum getDesigning() {
		return designing;
	}
	public void setDesigning(RatingEnum designing) {
		this.designing = designing;
	}
	public RatingEnum getIntegration() {
		return integration;
	}
	public void setIntegration(RatingEnum integration) {
		this.integration = integration;
	}
	public RatingEnum getProcess() {
		return process;
	}
	public void setProcess(RatingEnum process) {
		this.process = process;
	}
	public RatingEnum getQuality() {
		return quality;
	}
	public void setQuality(RatingEnum quality) {
		this.quality = quality;
	}
	public RatingEnum getTesting() {
		return testing;
	}
	public void setTesting(RatingEnum testing) {
		this.testing = testing;
	}
	public RatingEnum getStructuredTechniques() {
		return structuredTechniques;
	}
	public void setStructuredTechniques(RatingEnum structuredTechniques) {
		this.structuredTechniques = structuredTechniques;
	}
	public RatingEnum getDocumentation() {
		return documentation;
	}
	public void setDocumentation(RatingEnum documentation) {
		this.documentation = documentation;
	}
	public RatingEnum getTechSupport() {
		return techSupport;
	}
	public void setTechSupport(RatingEnum techSupport) {
		this.techSupport = techSupport;
	}
	public RatingEnum getSysAdministration() {
		return sysAdministration;
	}
	public void setSysAdministration(RatingEnum sysAdministration) {
		this.sysAdministration = sysAdministration;
	}
	public RatingEnum getPlanningAndOrganizing() {
		return planningAndOrganizing;
	}
	public void setPlanningAndOrganizing(RatingEnum planningAndOrganizing) {
		this.planningAndOrganizing = planningAndOrganizing;
	}
	public RatingEnum getScheduleManagement() {
		return scheduleManagement;
	}
	public void setScheduleManagement(RatingEnum scheduleManagement) {
		this.scheduleManagement = scheduleManagement;
	}
	public RatingEnum getProjectManagement() {
		return projectManagement;
	}
	public void setProjectManagement(RatingEnum projectManagement) {
		this.projectManagement = projectManagement;
	}
	public RatingEnum getProjectEstimationSkills() {
		return projectEstimationSkills;
	}
	public void setProjectEstimationSkills(RatingEnum projectEstimationSkills) {
		this.projectEstimationSkills = projectEstimationSkills;
	}
	public RatingEnum getPeopleManagement() {
		return peopleManagement;
	}
	public void setPeopleManagement(RatingEnum peopleManagement) {
		this.peopleManagement = peopleManagement;
	}
	public RatingEnum getOverallRating() {
		return overallRating;
	}
	public void setOverallRating(RatingEnum overallRating) {
		this.overallRating = overallRating;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}
