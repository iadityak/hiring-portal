package com.idemia.hiring.mapper;

import org.springframework.stereotype.Component;

import com.idemia.hiring.dto.CandidateDTO;
import com.idemia.hiring.dto.InterviewDTO;
import com.idemia.hiring.dto.RequirementDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.Interview;
import com.idemia.hiring.entity.Requirement;

@Component
public class ObjectMapper {

	public Candidate convertToCandidateEntity (CandidateDTO candidateDTO) {
		Candidate candidate= new Candidate();
		candidate.setPanCard(candidateDTO.getPanCard());
		candidate.setFirstName(candidateDTO.getFirstName());
		candidate.setLastName(candidateDTO.getLastName());
		candidate.setEmail(candidateDTO.getEmail());
		candidate.setPhoneNumber(candidateDTO.getPhoneNumber());
		candidate.setExperienceYears(candidateDTO.getExperienceYears());
		candidate.setStatus(candidateDTO.getStatus().toString());
		candidate.setSkillSet(candidateDTO.getSkillSet());
		candidate.setRequirement(null);
		return candidate;
		
	}

	public Requirement convertToRequirementEntity(RequirementDTO requirementDTO) {
		Requirement requirement = new Requirement();
		requirement.setDateOfOpening(requirementDTO.getDateOfOpening());
		requirement.setSubDomain(requirementDTO.getSubDomain());
		requirement.setDomain(requirementDTO.getDomain());
		requirement.setJobStatus(requirementDTO.getJobStatus());
		requirement.setPosition(requirementDTO.getPosition());
		requirement.setReportingManager(requirementDTO.getReportingManager());
		requirement.setJobDescription(requirementDTO.getJobDescription());
		requirement.setRequisitionId(requirementDTO.getRequisitionId());
		return requirement;
	}
	
	public Interview convertToInterviewEntity(InterviewDTO interviewDTO) {
		Interview interview = new Interview();
		interview.setDateOfInterview(interviewDTO.getDateOfInterview());
		interview.setDomainLogic(interviewDTO.getDomainLogic());
		interview.setInterviewerComments(interviewDTO.getInterviewerComments());
		interview.setInterviewerName(interviewDTO.getInterviewerName());
		interview.setRoundNumber(interviewDTO.getRoundNumber());
		interview.setRoundStatus(interview.getRoundStatus());
		return interview;
	}
}
