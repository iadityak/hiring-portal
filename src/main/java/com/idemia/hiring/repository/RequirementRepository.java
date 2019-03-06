package com.idemia.hiring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idemia.hiring.entity.Requirement;

@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Integer> {

	Requirement findByRequisitionId(String RequisitionId);

}
