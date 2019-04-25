package com.idemia.hiring.service.Impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idemia.hiring.dto.CandDashResponseDTO;
import com.idemia.hiring.dto.CandFilterBean;
import com.idemia.hiring.dto.CandStatusCountDTO;
import com.idemia.hiring.dto.CandidateDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.Requirement;
import com.idemia.hiring.enums.ProfileStatus;
import com.idemia.hiring.exception.AppError;
import com.idemia.hiring.exception.CandidateException;
import com.idemia.hiring.mapper.ObjectMapper;
import com.idemia.hiring.repository.CandidateRepository;
import com.idemia.hiring.repository.RequirementRepository;
import com.idemia.hiring.service.CandidateService;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService{
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private RequirementRepository requirementRepository;
	
	
	@Autowired
	private ObjectMapper objectMapper;
	
//	@Bean
//	public ModelMapper modelMapper() {
//		return new ModelMapper();
//	}
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	@Transactional
	public void addCandidate(CandidateDTO candidateDTO) {
		Candidate candidate = objectMapper.convertToCandidateEntity(candidateDTO);
		Requirement requirement = requirementRepository.findByRequisitionId(candidateDTO.getRequisitionId());
		if (requirement!=null) {
			candidate.setRequirement(requirement);
			requirement.getCandidate().add(candidate);
			candidateRepository.save(candidate);
			

		} else
			throw new CandidateException("Requirement doesn't exist");
	}

	@Override
	public List<Candidate> allCandidates() {
		return candidateRepository.findAll(sortCandidatesByIdDesc());
	}

	@Override
	public CandidateDTO findCandbyPhoneNumber(String phoneNumber) {
		Candidate candidate = candidateRepository.findByPhoneNumber(phoneNumber);
		if (candidate != null) {
			String reqId = candidate.getRequirement().getRequisitionId();
			return objectMapper.convertEntitytoCandidateDTO(candidate,reqId);}

		else
			throw new CandidateException(AppError.noCandForPhone + phoneNumber);
	}

	@Override
	public void updateCandidate(CandidateDTO candidateDTO, String panCard) {
		Candidate can = candidateRepository.findByPhoneNumber(panCard);
		if (can != null) {
			Candidate candidate = objectMapper.convertToCandidateEntity(candidateDTO);
			candidate.setCandidateId(can.getCandidateId());
			candidateRepository.save(candidate);
		} else
			throw new CandidateException("UPDATE FAIL. Candidate doesn't exist");
	}

	public boolean isCandidateExistsByPhone(String phoneNumber) {
		return candidateRepository.existsByPhoneNumber(phoneNumber);
	}

	private Sort sortCandidatesByIdDesc() {
		return new Sort(Sort.Direction.DESC, "candidateId");
	}

	@Override
	public Candidate eagerGetCandidateByPhone(String phoneNumber) {
		Candidate candidate = candidateRepository.findByPhoneNumber(phoneNumber);
		if (candidate != null) {
			candidate.setRequirement(candidate.getRequirement());
			candidate.getInterview();
			return candidate;
		} else
			throw new CandidateException(AppError.candPhoneExists);
	}

	@Override
	public CandStatusCountDTO getCandStatusCount() {
		CandStatusCountDTO candStatusCountDTO = new CandStatusCountDTO();
		candStatusCountDTO.setInterviewedCount(candidateRepository.countByStatus(ProfileStatus.NEXT_ROUND.name()));
		candStatusCountDTO.setSelectedCount(candidateRepository.countByStatus(ProfileStatus.SELECTED.name()));
		candStatusCountDTO.setRejectedCount(candidateRepository.countByStatus(ProfileStatus.REJECTED.name()));
		return candStatusCountDTO;
	}

	@Override
	public List<CandDashResponseDTO> filterCandidates(CandFilterBean candFilterBean) {
		List<CandDashResponseDTO> listOfCandidates = null;
		List<Candidate> listOfCand = null;
		if (candFilterBean != null) {
			if (candFilterBean.getCandStatus() != null) {
				if (candFilterBean.getStartDate() == null) {
					LocalDateTime startDateOneWk = LocalDate.now().atStartOfDay().minusWeeks(1);
					candFilterBean.setStartDate(startDateOneWk.toString());
				}
				if (candFilterBean.getEndDate() == null)
					candFilterBean.setEndDate(LocalDateTime.now().toString());
				listOfCand = candidateRepository.getCandOnStatus(candFilterBean.getCandStatus(),
						candFilterBean.getStartDate(), candFilterBean.getEndDate());
				if (listOfCand != null && !listOfCand.isEmpty()) {
					listOfCandidates = new ArrayList<>(0);
					listOfCandidates = mapListOfCand(listOfCandidates, listOfCand);
				}
				if (listOfCandidates != null && !listOfCandidates.isEmpty())
					return listOfCandidates;
			}
		}
		return listOfCandidates;
	}

	private List<CandDashResponseDTO> mapListOfCand(List<CandDashResponseDTO> listOfCandidates,
			List<Candidate> listOfCand) {
		listOfCand.parallelStream().forEach(candidate -> {
			CandDashResponseDTO candDashResponseDTO = new CandDashResponseDTO();
			modelMapper.map(candidate, candDashResponseDTO);
			listOfCandidates.add(candDashResponseDTO);

		});
		return listOfCandidates;
	}

}
