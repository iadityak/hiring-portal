package com.idemia.hiring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idemia.hiring.dto.CandDashResponseDTO;
import com.idemia.hiring.dto.CandFilterBean;
import com.idemia.hiring.dto.CandStatusCountDTO;
import com.idemia.hiring.service.DashboardService;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin
public class DashboardController {

	@Autowired
	private DashboardService dashboardService;

	@GetMapping("getstatuscount")
	public CandStatusCountDTO getCandStatusCount() {
		return dashboardService.getCandStatusCount();
	}

	@PostMapping("/filtercand")
	public List<CandDashResponseDTO> filterCandidates(@RequestBody CandFilterBean candFilterBean) {
		return dashboardService.filterCandidates(candFilterBean);
	}

}
