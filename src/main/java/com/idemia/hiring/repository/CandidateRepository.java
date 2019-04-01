package com.idemia.hiring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.idemia.hiring.entity.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate,String>{


	Candidate findByPhoneNumber(String phoneNumber);

	boolean existsByPhoneNumber(String phoneNumber);

	List<Candidate> findByEmail(String emailId);

	Integer countByStatus(String status);

	@Query(nativeQuery = true)
	List<Candidate> getCandOnStatus(@Param("candStatus") String candStatus, @Param("startDate") String startDate,
			@Param("endDate") String endDate);

}
