package com.idemia.hiring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.idemia.hiring.entity.Resume;
import com.idemia.hiring.exception.FileStorageException;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Integer> {

	Resume findByCandidateId(String panCard) throws FileStorageException;

}
