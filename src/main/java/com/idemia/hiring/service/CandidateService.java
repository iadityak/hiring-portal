package com.idemia.hiring.service;

import java.util.List;

import com.idemia.hiring.dto.CandDashResponseDTO;
import com.idemia.hiring.dto.CandFilterBean;
import com.idemia.hiring.dto.CandStatusCountDTO;
import com.idemia.hiring.dto.CandidateDTO;
import com.idemia.hiring.entity.Candidate;

public interface CandidateService {

	void addCandidate(CandidateDTO candidateDTO);

	List<Candidate> allCandidates();

	CandidateDTO findCandbyPhoneNumber(String phoneNumber);

	void updateCandidate(CandidateDTO candidateDTO, String panCard );
	
	boolean isCandidateExistsByPhone(String phoneNumber);

	Candidate eagerGetCandidateByPhone(String phoneNumber);

	CandStatusCountDTO getCandStatusCount();

	List<CandDashResponseDTO> filterCandidates(CandFilterBean candFilterBean);
}
