package com.idemia.hiring.dto;

public class CandidateDTO {

	private String panCard;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String experienceYears;
	private String skillSet;
	private String resume;
	private String requisitionId;
	private Status status;
	private String onlineScore;
	
	public enum Status {
		PROFILE_CREATED, ONGOING_INTERVIEW, SELECTED, REJECTED
	}
	
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getExperienceYears() {
		return experienceYears;
	}
	public void setExperienceYears(String experienceYears) {
		this.experienceYears = experienceYears;
	}
	public String getSkillSet() {
		return skillSet;
	}
	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getRequisitionId() {
		return requisitionId;
	}
	public void setRequisitionId(String requisitionId) {
		this.requisitionId = requisitionId;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public String getOnlineScore() {
		return onlineScore;
	}
	public void setOnlineScore(String onlineScore) {
		this.onlineScore = onlineScore;
	}
	
}
