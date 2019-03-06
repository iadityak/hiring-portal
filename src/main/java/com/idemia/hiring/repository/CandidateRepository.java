package com.idemia.hiring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idemia.hiring.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate,String>{

	@Transactional
	Candidate findByPanCard(String candidatePanCard);

}
