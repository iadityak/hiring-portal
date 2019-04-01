package com.idemia.hiring.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idemia.hiring.dto.CandDashResponseDTO;
import com.idemia.hiring.dto.CandFilterBean;
import com.idemia.hiring.dto.CandStatusCountDTO;
import com.idemia.hiring.service.CandidateService;
import com.idemia.hiring.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private CandidateService candidateService;

	@Override
	public CandStatusCountDTO getCandStatusCount() {
		return candidateService.getCandStatusCount();
	}

	@Override
	public List<CandDashResponseDTO> filterCandidates(CandFilterBean candFilterBean) {
		return candidateService.filterCandidates(candFilterBean);
	}

}
