package com.desidoc.management.users.admin.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.desidoc.management.employee.dto.EmpDesignationDTO;
import com.desidoc.management.employee.model.EmpCadre;
import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.repository.EmpCadreRepository;
import com.desidoc.management.employee.repository.EmpDesignationRepository;
import com.desidoc.management.employee.specifications.EmpDesignationSpecification;

@Service
public class EmpDesignationServiceImpl implements EmpDesignationService {

	@Autowired
	EmpDesignationRepository empDesignationRepository;

	@Autowired
	EmpCadreRepository empCadreRepository;

	@Override
	public List<EmpDesignationDTO> findAllEmpDesignationByOrderNo() {
		return empDesignationRepository.findAllByOrderByOrderNoDesc().stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<EmpDesignationDTO> searchEmpDesignation(String search) {
		Specification<EmpDesignation> sp = EmpDesignationSpecification.searchEmpDesignation(search);
		return empDesignationRepository.findAll(sp).stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public String updateEmpDesignation(EmpDesignationDTO designationDTO, Integer id) throws Exception {
		EmpDesignation emp = empDesignationRepository.findById(id)
				.orElseThrow(() -> new Exception("EmpDesignation not found"));
		empDesignationRepository.save(this.mapDtoToEntity(designationDTO, emp));
		
		return "Designation updated";
	}

	@Override
	public String deleteEmpDesignation(Integer id) {
		empDesignationRepository.deleteById(id);
		
		return "Designation deleted";
	}

	@Override
	public EmpDesignationDTO findEmpDesignationById(Integer id) throws Exception {
		EmpDesignation emp = empDesignationRepository.findById(id)
				.orElseThrow(() -> new Exception("EmpDesignation not found"));
		return convertToDTO(emp);
	}

	@Override
	public String createEmpDesignation(EmpDesignationDTO designationDTO) {
		EmpDesignation emp = new EmpDesignation();
		empDesignationRepository.save(this.mapDtoToEntity(designationDTO, emp));

		return "Designation created";
	}

	@Override
	public String updateOrderNo(Integer id, Integer newOrderNo) {
		EmpDesignation designation = empDesignationRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid designation ID"));
		designation.setOrderNo(newOrderNo);
		empDesignationRepository.save(designation);
		return "Designation updated";
	}

	
	// ---------- Helper Functions ----------

	// Converting DTOs to Entities
	private EmpDesignation mapDtoToEntity(EmpDesignationDTO dto, EmpDesignation emp) {
		if (dto.getCadreId() != null && !dto.getCadreId().equals(emp.getCadreId().getCadreId())) {
			EmpCadre cadre = new EmpCadre();
			cadre.setCadreId(dto.getCadreId());
			emp.setCadreId(cadre);
		}
		if (dto.getDesignFullName() != null
				&& !dto.getDesignFullName().equals(emp.getDesignFullName())) {
			emp.setDesignFullName(dto.getDesignFullName());
		}
		if (dto.getDesignShortName() != null
				&& !dto.getDesignShortName().equals(emp.getDesignShortName())) {
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

}
