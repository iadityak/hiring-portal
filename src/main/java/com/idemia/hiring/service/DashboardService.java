package com.idemia.hiring.service;

import java.util.List;

import com.idemia.hiring.dto.CandDashResponseDTO;
import com.idemia.hiring.dto.CandFilterBean;
import com.idemia.hiring.dto.CandStatusCountDTO;

public interface DashboardService {

	CandStatusCountDTO getCandStatusCount();

	List<CandDashResponseDTO> filterCandidates(CandFilterBean candFilterBean);

}
