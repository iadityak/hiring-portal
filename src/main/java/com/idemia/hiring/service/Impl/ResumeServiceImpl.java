package com.idemia.hiring.service.Impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.idemia.hiring.entity.Resume;
import com.idemia.hiring.exception.FileStorageException;
import com.idemia.hiring.repository.ResumeRepository;
import com.idemia.hiring.service.ResumeService;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Autowired
	private ResumeRepository resumeRepository;

	@Override
	public void upload(String phoneNumber, MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {

			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}
			Resume resume = new Resume(phoneNumber, file.getContentType(), file.getBytes());
			resumeRepository.save(resume);

		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	@Override
	public Resume download(String phoneNumber) {
		return resumeRepository.findByCandidateId(phoneNumber);
	}
}