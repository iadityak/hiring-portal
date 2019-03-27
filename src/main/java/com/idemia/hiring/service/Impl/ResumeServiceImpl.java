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
	public void upload(String panCard, MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		System.out.println(fileName);
		try {

			if (fileName.contains("..")) {
				throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
			}
			Resume resume = new Resume(panCard, file.getContentType(), file.getBytes());
			resumeRepository.save(resume);

		} catch (IOException ex) {
			throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
		}
	}

	@Override
	public Resume download(String panCard) {
		return resumeRepository.findByCandidateId(panCard);
	}
}