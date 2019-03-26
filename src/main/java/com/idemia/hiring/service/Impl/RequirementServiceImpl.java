package com.idemia.hiring.service.Impl;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.idemia.hiring.dto.RequirementDTO;
import com.idemia.hiring.entity.Candidate;
import com.idemia.hiring.entity.Requirement;
import com.idemia.hiring.exception.CandidateException;
import com.idemia.hiring.mapper.ObjectMapper;
import com.idemia.hiring.repository.RequirementRepository;
import com.idemia.hiring.service.RequirementService;

@Service
public class RequirementServiceImpl implements RequirementService {

	@Autowired
	private RequirementRepository requirementRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Override
	public void addRequirement(RequirementDTO requirementDTO) {
		Requirement requirement = new Requirement();
		requirement = objectMapper.convertToRequirementEntity(requirementDTO);
		requirementRepository.save(requirement);
	}

	@Override
	@Transactional
	public List<Requirement> getAllRequirements() {
		return requirementRepository.findAll();
	}

	@Override
	@Transactional
	public List<Candidate> getCandidatesFroRequirements(String requisitionId) {
		Requirement requirement = requirementRepository.findByRequisitionId(requisitionId);
		if (requirement != null) {
			Hibernate.initialize(requirement.getCandidate());
			List<Candidate> candidate = requirement.getCandidate();
			if (candidate != null) {
				return candidate;
			} else
				throw new CandidateException("No Candidate exist for this Requirement");
		}

		else
			throw new CandidateException("Invalid Requisition ID");
	}

	@Override
	@Transactional
	public void uploadAllRequirement(MultipartFile file) throws EncryptedDocumentException, InvalidFormatException, IOException {

		Workbook workbook = WorkbookFactory.create(file.getInputStream());
		Iterator<Sheet> sheetIterator = workbook.sheetIterator();
		while (sheetIterator.hasNext()) {
			Sheet sheet = sheetIterator.next();
		}
		Sheet sheet = workbook.getSheetAt(0);
		DataFormatter dataFormatter = new DataFormatter();

		Iterator<Row> rowIterator = sheet.rowIterator();
		while (rowIterator.hasNext()) {
			List<String> rowValue = new ArrayList<>(0);
			Row row = rowIterator.next();
			if (row.getRowNum() != 0) {
				Requirement requirement = new Requirement();
				RequirementDTO requirementDTO = new RequirementDTO();
				Iterator<Cell> cellIterator = row.cellIterator();
				SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z");
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					if (cell.getColumnIndex() == 0)
						rowValue.add(sm.format(cell.getDateCellValue()));
					else
						rowValue.add(cell.getStringCellValue());
				}
				requirementDTO = preapreRequirementDTO(rowValue);
				requirement = objectMapper.convertToRequirementEntity(requirementDTO);
				requirementRepository.saveAndFlush(requirement);
			}
		}
	}

	private RequirementDTO preapreRequirementDTO(List<String> row) {
		RequirementDTO requirementDTO = new RequirementDTO();

		try {
			requirementDTO.setDateOfOpening(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss z").parse(row.get(0)));
			requirementDTO.setDomain(row.get(1));
			requirementDTO.setJobDescription(row.get(2));
			requirementDTO.setJobStatus(row.get(3));
			requirementDTO.setPosition(row.get(4));
			requirementDTO.setReportingManager(row.get(5));
			requirementDTO.setRequisitionId(row.get(6));
			requirementDTO.setSubDomain(row.get(7));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return requirementDTO;
	}
}
