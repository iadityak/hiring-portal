package com.idemia.hiring.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 *@author G521774 (aditya.kumar@idemia.com)
 *  
 */

@Entity
@Table(name="candidate")
@NamedNativeQuery(name = "Candidate.getCandOnStatus", query = "call get_cand_on_status(:candStatus,:startDate,:endDate)", resultSetMapping = "CandResult")
@SqlResultSetMapping(name = "CandResult", classes = { @ConstructorResult(targetClass = Candidate.class, columns = {
		@ColumnResult(name = "firstName"), @ColumnResult(name = "lastName"), @ColumnResult(name = "phoneNumber"),
		@ColumnResult(name = "email"), @ColumnResult(name = "skillSet"), @ColumnResult(name = "experienceYears"),
		@ColumnResult(name = "onlineScore") }) })
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer candidateId;
	
	private String firstName;
	
	private String lastName;
	
	@Column(length = 20, unique = true, nullable = false)
	private String phoneNumber;
	
	private String email;
	
	private String experienceYears;

	private String skillSet;
	
	@OneToOne(fetch = FetchType.LAZY)
	private Resume resume;
	
	private String onlineScore;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidate")
		@JsonIgnore
	private final List<Interview> interview = new ArrayList<>();

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "requisition_id")
	@JsonIgnore
	private Requirement requirement;
	
	private String status;
	
	
	@CreationTimestamp
	@Column(nullable = false,updatable = false)
	private Timestamp dateOfEnrollment;
	
	@UpdateTimestamp
	private Timestamp lastUpdated;
	@OneToMany(mappedBy = "candFeedCandidate")
	@JsonIgnore
	private List<CandidateFeedback> listOfCandidateFeedback;

	public Candidate() {
		super();
	}
	public Candidate(String firstName, String lastName, String phoneNumber, String email,String skillSet, String experienceYears
			, String onlineScore, Requirement requirement) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.experienceYears = experienceYears;
		this.skillSet = skillSet;
		this.onlineScore = onlineScore;
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
	public Resume getResume() {
		return resume;
	}
	public void setResume(Resume resume) {
		this.resume = resume;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Requirement getRequirement() {
		return requirement;
	}
	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}
	public List<Interview> getInterview() {
		return interview;
	}
	public String getOnlineScore() {
		return onlineScore;
	}
	public void setOnlineScore(String onlineScore) {
		this.onlineScore = onlineScore;
	}
	@Override
	public String toString() {
		return "Candidate [candidateId=" + candidateId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", email=" + email + ", experienceYears="
				+ experienceYears + ", skillSet=" + skillSet + ", resume=" + resume + ", onlineScore=" + onlineScore
				+ ", interview=" + interview + ", requirement=" + requirement + ", status=" + status
				+ ", dateOfEnrollment=" + dateOfEnrollment + ", lastUpdated=" + lastUpdated + "]";
	}
	public Timestamp getDateOfEnrollment() {
		return dateOfEnrollment;
	}
	public void setDateOfEnrollment(Timestamp dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}
	public List<CandidateFeedback> getListOfCandidateFeedback() {
		return listOfCandidateFeedback;
	}
	public void setListOfCandidateFeedback(List<CandidateFeedback> listOfCandidateFeedback) {
		this.listOfCandidateFeedback = listOfCandidateFeedback;
	}
}
