package com.idemia.hiring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.idemia.hiring.entity.Resume;
import com.idemia.hiring.service.ResumeService;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin
public class ResumeController {
	
	@Autowired
	private ResumeService resumeService;
	
	@PostMapping("/upload/{phoneNumber}")
	public void uploadResume(@PathVariable(value = "phoneNumber") String phoneNumber, @RequestBody MultipartFile file) {
		System.out.println("Uploading...");
		resumeService.upload(phoneNumber,file);
	}
	
	@GetMapping("/download/{phoneNumber}") 
	public ResponseEntity<Resource> downloadResume(@PathVariable(value = "phoneNumber") String phoneNumber) {
		Resume resume = resumeService.download(phoneNumber);
		return ResponseEntity.ok()
	                .contentType(MediaType.parseMediaType(resume.getFiletype()))
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resume.getCandidateId() + "\"")
	                .body(new ByteArrayResource(resume.getResume()));
	}
	
	
}
