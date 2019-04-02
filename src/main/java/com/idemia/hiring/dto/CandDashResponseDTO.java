package com.idemia.hiring.dto;

/**
 * @author G521917(aman.ahuja@idemia.com)
 * 
 *         Contains candidate information used while displaying Candidate
 *         information on Hiring Portal DASHBOARD.
 *
 */
public class CandDashResponseDTO {

	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String email;
	private String skillSet;
	private String experienceYears;
	private String onlineScore;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
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

	public String getExperienceYears() {
		return experienceYears;
	}

	public void setExperienceYears(String experienceYears) {
		this.experienceYears = experienceYears;
	}

	public String getOnlineScore() {
		return onlineScore;
	}

	public void setOnlineScore(String onlineScore) {
		this.onlineScore = onlineScore;
	}

}
