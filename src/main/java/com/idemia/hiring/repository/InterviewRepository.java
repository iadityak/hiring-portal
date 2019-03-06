package com.idemia.hiring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idemia.hiring.entity.Interview;

public interface InterviewRepository extends JpaRepository<Interview,Integer> {

	List<Interview> findByCandidatePanCard(String panCard);

}
