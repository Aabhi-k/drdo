package com.desidoc.management.users.admin.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.desidoc.management.employee.dto.EmpMasterDTO;
import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.model.EmpMaster;
import com.desidoc.management.employee.model.EmpRole;
import com.desidoc.management.employee.repository.EmpMasterRepository;
import com.desidoc.management.employee.specifications.EmpMasterSpecification;
import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.lab.model.LabMaster;

@Service
public class EmpMasterServiceImpl implements EmpMasterService {

	@Autowired
	EmpMasterRepository repository;
	@Autowired
	EmpDesignationService empDesignationService;
	@Autowired
	EmpRoleService empRoleService;
	@Autowired
	LabMasterService labMasterService;
	
	// ---------- Helper Functions ----------

	// Converting DTOs to Entities
	private EmpMaster convertToEntity(EmpMasterDTO dto, EmpMaster emp) throws Exception {
		if (dto.getEmpTitle() != null && !dto.getEmpTitle().equals(emp.getEmpTitle())) {
			emp.setEmpTitle(dto.getEmpTitle());
		}
		if (dto.getEmpFirstName() != null && !dto.getEmpFirstName().equals(emp.getEmpFirstName())) {
			emp.setEmpFirstName(dto.getEmpFirstName());
		}
		if (dto.getEmpMiddleName() != null && !dto.getEmpMiddleName().equals(emp.getEmpMiddleName())) {
			emp.setEmpMiddleName(dto.getEmpMiddleName());
		}
		if (dto.getEmpLastName() != null && !dto.getEmpLastName().equals(emp.getEmpLastName())) {
			emp.setEmpLastName(dto.getEmpLastName());
		}
		if (dto.getEmpDesignId() != null) {
			if (emp.getEmpDesignId() == null || !dto.getEmpDesignId().equals(emp.getEmpDesignId().getId())) {
				emp.setEmpDesignId(empDesignationService.findEmpDesignationById(dto.getEmpDesignId()));
			}

		}
		if (dto.getLabId() != null) {
			if (emp.getLabId() == null || !dto.getLabId().equals(emp.getLabId().getId())) {
				emp.setLabId(labMasterService.findLabMasterById(dto.getLabId()));
			}
		}
		if (dto.getEmpRoleId() != null) {
			if (emp.getEmpRoleId() == null || !dto.getEmpRoleId().equals(emp.getEmpRoleId().getId())) {
				emp.setEmpRoleId(empRoleService.findEmpRoleById(dto.getEmpRoleId()));
			}
		}
		if (dto.getOfficeRoomNo() != null && !dto.getOfficeRoomNo().equals(emp.getOfficeRoomNo())) {
			emp.setOfficeRoomNo(dto.getOfficeRoomNo());
		}

		if (dto.getLastUpdated() != null && !dto.getLastUpdated().equals(emp.getLastUpdated())) {
			emp.setLastUpdated(LocalDateTime.now());
		}
		if (dto.getViewingOrder() != null && !dto.getViewingOrder().equals(emp.getViewingOrder())) {
			emp.setViewingOrder(dto.getViewingOrder());
		}
		if (dto.getAddlDesign() != null && !dto.getAddlDesign().equals(emp.getAddlDesign())) {
			emp.setAddlDesign(dto.getAddlDesign());
		}
		if (dto.getDeleted() != null && !dto.getDeleted().equals(emp.getDeleted())) {
			emp.setDeleted(dto.getDeleted());
		}
		return emp;
	}

	// converting Entity to DTO
	private EmpMasterDTO convertToDTO(EmpMaster empMaster) {
		EmpMasterDTO dto = new EmpMasterDTO();

		dto.setId(empMaster.getId());
		dto.setEmpTitle(empMaster.getEmpTitle());
		dto.setEmpFirstName(empMaster.getEmpFirstName());
		dto.setEmpMiddleName(empMaster.getEmpMiddleName());
		dto.setEmpLastName(empMaster.getEmpLastName());
		dto.setEmpDesignId(empMaster.getEmpDesignId().getId());
		dto.setOfficeRoomNo(empMaster.getOfficeRoomNo());
		dto.setLabId(empMaster.getLabId().getId());
		dto.setEmpRoleId(empMaster.getEmpRoleId().getId());
		dto.setLastUpdated(LocalDateTime.now());
		dto.setViewingOrder(empMaster.getViewingOrder());
		dto.setAddlDesign(empMaster.getAddlDesign());
		dto.setDeleted(empMaster.getDeleted());

		return dto;
	}

	// Finding by Id
	@Override
	public EmpMaster findEmpMasterById(Integer id) throws Exception {
		EmpMaster emp = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("entry not founnd"));

		return emp;
	}

	@Override
	public List<EmpMasterDTO> findAllEmpMaster() {

		return repository.findAllByOrderByViewingOrderDesc().stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<EmpMasterDTO> findAllEmpMasterByDeleted() {

		return repository.findAllByDeletedOrderByViewingOrderDesc("0").stream().map(this::convertToDTO)
				.collect(Collectors.toList());
	}

	@Override
	public List<EmpMasterDTO> searchEmpMaster(String search) {
		Specification<EmpMaster> sp = EmpMasterSpecification.searchEmpMaster(search);

		return repository.findAll(sp).stream().map(this::convertToDTO).collect(Collectors.toList());

	}

	@Override
	public String updateEmpMaster(EmpMasterDTO empMasterDTO, Integer id) throws Exception {
		EmpMaster emp = this.findEmpMasterById(id);
		repository.save(this.convertToEntity(empMasterDTO, emp));

		return "Employee updated";
	}

	@Override
	public String deleteEmpMaster(Integer id) throws Exception {
		EmpMaster emp = this.findEmpMasterById(id);

		emp.setDeleted("1");
		repository.save(emp);

		return "Employee deleted";
	}

	@Override
	public String createEmpMaster(EmpMasterDTO empMasterDTO) throws Exception {

		EmpMaster emp = new EmpMaster();
		repository.save(this.convertToEntity(empMasterDTO, emp));

		return "Employee created";
	}

	@Override
	public String updateViewingOrder(Integer id, String order) throws Exception {
		EmpMaster emp = repository.findById(id).orElseThrow(() -> new Exception("Employee not found"));
		emp.setViewingOrder(order);
		repository.save(emp);
		return "Employee updated";
	}

}
