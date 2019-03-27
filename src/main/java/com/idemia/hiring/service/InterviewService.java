package com.idemia.hiring.service;

import java.util.List;

import com.idemia.hiring.dto.InterviewDTO;
import com.idemia.hiring.entity.Interview;

public interface InterviewService {

	void addInterview(InterviewDTO interviewDTO);

	List<Interview> getAllInterview(String panCard);

	Interview findByInterviewId(Integer interviewId);

}
