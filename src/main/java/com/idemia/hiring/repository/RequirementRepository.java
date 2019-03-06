package com.idemia.hiring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.Requirement;

public interface RequirementRepository extends JpaRepository<Requirement,Integer> {

	Requirement findByRequisitionId(String RequisitionId);
	
}
