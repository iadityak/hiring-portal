package com.idemia.hiring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idemia.hiring.entity.CandidateFeedback;

/**
 * Specifies methods used to obtain and modify CandidateFeedback related
 * information which is stored in the database.
 */
@Repository
public interface CandidateFeedbackRepository extends JpaRepository<CandidateFeedback, Integer> {

}
