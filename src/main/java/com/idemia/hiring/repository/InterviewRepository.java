package com.idemia.hiring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idemia.hiring.entity.Interview;

@Repository
public interface InterviewRepository extends JpaRepository<Interview,Integer> {

	List<Interview> findByCandidatePanCard(String panCard);
	
	Interview findByInterviewId(Integer interviewId);

}
