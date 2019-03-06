package com.idemia.hiring.service;

import org.springframework.web.multipart.MultipartFile;

import com.idemia.hiring.entity.Resume;

public interface ResumeService {

	void upload(String panCard, MultipartFile file);

	Resume download(String panCard);

}
