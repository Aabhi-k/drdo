package com.desidoc.management.users.admin.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.desidoc.management.employee.dto.EmpDesignationDTO;
import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.repository.EmpDesignationRepository;
import com.desidoc.management.employee.specifications.EmpDesignationSpecification;

@Service
public class EmpDesignationServiceImpl implements EmpDesignationService {

	@Autowired
	EmpDesignationRepository repository;

	@Autowired
	EmpCadreService empCadreService;

	// ---------- Helper Functions ----------

	// Converting DTOs to Entities
	private EmpDesignation convertToEntity(EmpDesignationDTO dto, EmpDesignation emp) {
		if (dto.getCadreId() != null) {
			if (emp.getCadreId() == null || !dto.getCadreId().equals(emp.getCadreId().getCadreId())) {
				emp.setCadreId(empCadreService.findEmpCadreById(dto.getCadreId()));
			}
		}
		if (dto.getDesignFullName() != null && !dto.getDesignFullName().equals(emp.getDesignFullName())) {
			emp.setDesignFullName(dto.getDesignFullName());
		}
		if (dto.getDesignShortName() != null && !dto.getDesignShortName().equals(emp.getDesignShortName())) {
			emp.setDesignShortName(dto.getDesignShortName());
		}
		if (dto.getOrderNo() != null && !dto.getOrderNo().equals(emp.getOrderNo())) {
			emp.setOrderNo(dto.getOrderNo());
		}

		return emp;
	}

	// Converting Entities to DTOs
	private EmpDesignationDTO convertToDTO(EmpDesignation designation) {
		EmpDesignationDTO dto = new EmpDesignationDTO();
		dto.setId(designation.getId());
		dto.setDesignShortName(designation.getDesignShortName());
		dto.setDesignFullName(designation.getDesignFullName());
		dto.setCadreId(designation.getCadreId().getCadreId());
		dto.setOrderNo(designation.getOrderNo());
		return dto;
	}

	// Finding all by Id
	@Override
	public EmpDesignation findEmpDesignationById(Integer id) throws Exception {
		return repository.findById(id)
				.orElseThrow(() -> new Exception("Employee Designation not found"));
	}

	@Override
	public List<EmpDesignationDTO> findAllEmpDesignationByOrderNo() {
		return repository.findAllByOrderByOrderNoDesc().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public List<EmpDesignationDTO> searchEmpDesignation(String search) {
		Specification<EmpDesignation> sp = EmpDesignationSpecification.searchEmpDesignation(search);
		return repository.findAll(sp).stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public String updateEmpDesignation(EmpDesignationDTO designationDTO, Integer id) throws Exception {
		EmpDesignation emp = this.findEmpDesignationById(id);
		repository.save(this.convertToEntity(designationDTO, emp));

		return "Designation updated";
	}

	@Override
	public String deleteEmpDesignation(Integer id) {
		repository.deleteById(id);

		return "Designation deleted";
	}

	@Override
	public String createEmpDesignation(EmpDesignationDTO designationDTO) {
		EmpDesignation emp = new EmpDesignation();
		emp = convertToEntity(designationDTO, emp);
		repository.save(emp);

		return "Designation created";
	}

	@Override
	public String updateOrderNo(Integer id, Integer newOrderNo) throws Exception {
		EmpDesignation designation = this.findEmpDesignationById(id);
		designation.setOrderNo(newOrderNo);
		repository.save(designation);
		return "Designation updated";
	}

	// to be used in future if we need to
	@Override
	public List<EmpDesignationDTO> getAllEmpDesignationShortName() {
		return repository.findByDesignShortNameIsNotNull().stream().map(projection -> {
			EmpDesignationDTO dto = new EmpDesignationDTO();
			dto.setDesignShortName(projection.getDesignShortName());
			return dto;
		}).collect(Collectors.toList());

	}

	// to be used in future if we need to
	@Override
	public List<EmpDesignationDTO> getAllEmpDesignationFullName() {
		return repository.findByDesignFullNameIsNotNull().stream().map(projection -> {
			EmpDesignationDTO dto = new EmpDesignationDTO();
			dto.setDesignFullName(projection.getDesignFullName());
			return dto;
		}).collect(Collectors.toList());

	}

}
