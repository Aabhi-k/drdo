package com.desidoc.management.users.admin.service.emp;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.desidoc.management.employee.dto.EmpDesignationDTO;
import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignProjection;
import com.desidoc.management.employee.repository.EmpDesignationRepository;
import com.desidoc.management.employee.specifications.EmpDesignationSpecification;
import com.desidoc.management.exception.EntityNotFoundException;

@Service
public class EmpDesignationServiceImpl implements EmpDesignationService {

	@Autowired
	EmpDesignationRepository repository;

	@Autowired
	EmpCadreService empCadreService;

	// ---------- Helper Functions ----------

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

	// Converting DTO to projection
	private EmpDesignProjection convertToProjection(EmpDesignationDTO dto) {
		return new EmpDesignProjection() {
			@Override
			public String getDesignShortName() {
				return dto.getDesignShortName(); // Assuming this field exists in the DTO
			}

			@Override
			public String getDesignFullName() {
				return dto.getDesignFullName(); // Assuming this field exists in the DTO
			}

			@Override
			public String getCadreShortName() {
				return empCadreService.findEmpCadreById(dto.getCadreId()).getCadreShortName(); // Assuming this field
																								// exists in the DTO
			}
		};
	}

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

	// ----------------- Find Methods ----------------

	// Finding all by Id
	@Override
	public EmpDesignation findEmpDesignationById(Integer id) {
		Optional<EmpDesignation> optionalDesignation = repository.findById(id);
		
		EmpDesignation designation = optionalDesignation
				.orElseThrow(() -> new EntityNotFoundException("Employee Designation not found"));
		
		System.out.println(designation.getId());
		return designation; 
	}

	@Override
	public List<EmpDesignationDTO> findAllEmpDesignationByOrderNo() {
		return repository.findAllByOrderByOrderNoDesc().stream().map(this::convertToDTO).collect(Collectors.toList());
	}

	@Override
	public Page<EmpDesignProjection> findAllEmpDesignProjection(Pageable page) {
		return repository.findAllProjectedBy(page);
	}


	@Override
	public List<EmpDesignationDTO> findAllEmpDesignationShortName() {
		return repository.findByDesignShortNameIsNotNull().stream().map(projection -> {
			EmpDesignationDTO dto = new EmpDesignationDTO();
			dto.setDesignShortName(projection.getDesignShortName());
			return dto;
		}).collect(Collectors.toList());

	}

	// --------------- Search Methods ---------------
	@Override
	public Page<EmpDesignProjection> searchEmpDesignation(String search, Pageable page) {
		Specification<EmpDesignation> sp = EmpDesignationSpecification.searchEmpDesignation(search);
		return repository.findAll(sp, page).map(this::convertToDTO).map(this::convertToProjection);
	}
	

	
	// --------------- Update Methods ---------------
	@Override
	public String updateEmpDesignation(EmpDesignationDTO designationDTO, Integer id) throws Exception {
		EmpDesignation emp = this.findEmpDesignationById(id);
		repository.save(this.convertToEntity(designationDTO, emp));

		return "Designation updated";
	}
	
	@Override
	public String updateOrderNo(Integer id, Integer newOrderNo) throws Exception {
		EmpDesignation designation = this.findEmpDesignationById(id);
		designation.setOrderNo(newOrderNo);
		repository.save(designation);
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

	

	

	

}
