package com.idemia.hiring.service;

import java.util.List;

import com.idemia.hiring.dto.CandidateDTO;
import com.idemia.hiring.entity.Candidate;

public interface CandidateService {

	void addCandidate(CandidateDTO candidateDTO);

	List<Candidate> allCandidates();

	Candidate findCandidatebyPan(String panCard);

	void updateCandidate(CandidateDTO candidateDTO, String panCard );

}
