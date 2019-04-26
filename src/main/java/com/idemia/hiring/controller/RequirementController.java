package com.idemia.hiring.controller;


import java.io.File;
import java.io.IOException;
//import java.nio.file.Files;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.common.io.Files;
import com.idemia.hiring.dto.RequirementDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.Requirement;
import com.idemia.hiring.exception.AppError;
import com.idemia.hiring.exception.RequirementException;
import com.idemia.hiring.service.RequirementService;

@RestController
@RequestMapping("/api/requirement")
@CrossOrigin
public class RequirementController {
	
	@Autowired
	private RequirementService requirementService;
	
	@PostMapping("/add")
	public void addRequirements(@RequestBody RequirementDTO requirementDTO) {
		requirementService.addRequirement(requirementDTO);
	}
	
	@PostMapping("/upload")
	@CrossOrigin
	public void addAllRequirements(@RequestParam("file") MultipartFile file)
			throws InvalidFormatException, IOException, RequirementException {
		 String tempFile = file.getOriginalFilename();
		 String fileExtension = Files.getFileExtension(tempFile);
		 if(!fileExtension.equalsIgnoreCase("xls") && !fileExtension.equalsIgnoreCase("xlsx")) {
			 throw new RequirementException(AppError.fileError);
		 }
		 requirementService.uploadAllRequirement(file);
		 }
	
//	@RequestMapping(value="/downloadExcelFile",method=RequestMethod.GET,produces=MediaType.APPLICATION_ATOM_XML_VALUE)
//	public ResponseEntity<byte[]> testMethod(){
//		HttpHeaders responseHeaders = new HttpHeaders();
//		responseHeaders.setContentDispositionFormData("attachment","Sample.xlsx");
//		responseHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//		File file = new File("./src/main/resources/sample.xlsx");
//		Path path = Paths.get(file.getAbsolutePath());
//		ByteArrayResource resource = null;
//		try {
//			resource = new ByteArrayResource(Files.readAllBytes(path));
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//		return new ResponseEntity<byte[]>(resource.getByteArray(),responseHeaders,HttpStatus.OK);
//	}
	
	
	@GetMapping("/get/all")
	public List<Requirement> getAllRequirements() {
		return requirementService.getAllRequirements();
	}
	
	@GetMapping("/get/{RquisitionId}")
	public List<Candidate> getCandidatesForRequirement(@PathVariable(value="RquisitionId",required=true) String requisitionId){
		return requirementService.getCandidatesFroRequirements(requisitionId);
		
	}
	@GetMapping("/get/requirementDetail/{RquisitionId}")
	public Requirement getRequirementDetail(@PathVariable(value="RquisitionId",required=true) String requisitionId)
			throws RequirementException {
		return requirementService.getRequirementDetail(requisitionId);
	}
}