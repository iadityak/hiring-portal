package com.idemia.hiring.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.web.multipart.MultipartFile;

import com.idemia.hiring.dto.RequirementDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.Requirement;
import com.idemia.hiring.exception.RequirementException;


public interface RequirementService {

	void addRequirement(RequirementDTO requirementDTO);

	List<Requirement> getAllRequirements();

	List<Candidate> getCandidatesFroRequirements(String requisitionId);

	void uploadAllRequirement(MultipartFile file) throws EncryptedDocumentException, InvalidFormatException, IOException;

	Requirement getRequirementDetail(String requisitionId) throws RequirementException;

}
