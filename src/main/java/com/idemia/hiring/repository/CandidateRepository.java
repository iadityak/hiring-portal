package com.idemia.hiring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idemia.hiring.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,String>{


	Candidate findByPanCard(String candidatePanCard);

	boolean existsByPanCard(String pan);
	
	List<Candidate> findByEmail(String emailId);

}
