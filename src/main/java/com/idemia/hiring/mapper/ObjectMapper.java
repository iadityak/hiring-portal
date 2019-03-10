package com.idemia.hiring.mapper;

import org.springframework.stereotype.Component;

import com.idemia.hiring.dto.CandidateDTO;
import com.idemia.hiring.dto.InterviewDTO;
import com.idemia.hiring.dto.RequirementDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.Interview;
import com.idemia.hiring.entity.Requirement;

import ma.glasnost.orika.BoundMapperFacade;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class ObjectMapper {

	MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
	
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
		candidate.setOnlineScore(candidateDTO.getOnlineScore());
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
//		mapperFactory.classMap(InterviewDTO.class, Interview.class).byDefault().register();
//		MapperFacade mapper = mapperFactory.getMapperFacade();
//		Interview interview= mapper.map(interviewDTO, Interview.class);
//		return interview;
		
		Interview interview = new Interview();
		interview.setDateOfInterview(interviewDTO.getDateOfInterview());
		interview.setDomainLogic(interviewDTO.getDomainLogic());
		interview.setInterviewerComments(interviewDTO.getInterviewerComments());
		interview.setInterviewerName(interviewDTO.getInterviewerName());
		interview.setRoundNumber(interviewDTO.getRoundNumber());
		interview.setRoundStatus(interviewDTO.getRoundStatus());
		interview.setAnalysis(interviewDTO.getAnalysis());
		interview.setDesigning(interviewDTO.getDesigning());
		interview.setDocumentation(interviewDTO.getDocumentation());
		interview.setIntegration(interviewDTO.getIntegration());
		interview.setOverallRating(interviewDTO.getOverallRating());
		return interview;
	}
}
