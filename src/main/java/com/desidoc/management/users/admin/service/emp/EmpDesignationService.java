package com.desidoc.management.users.admin.service.emp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desidoc.management.employee.dto.EmpDesignationDTO;
import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignProjection;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignationDropDownProjection;

public interface EmpDesignationService {

	// Find Methods
	EmpDesignation findEmpDesignationById(Integer id);

	List<EmpDesignationDTO> findAllEmpDesignationByOrderNo();

	Page<EmpDesignProjection> findAllEmpDesignProjection(Pageable page);

	// Finding individual columns

	List<EmpDesignationDTO> findAllEmpDesignationShortName();

	List<EmpDesignationDropDownProjection> findAllForDropDown();

	// Search
	Page<EmpDesignProjection> searchEmpDesignation(String search, Pageable page);

	List<EmpDesignationDropDownProjection> searchEmpDesignationDropDown(String query);

	// Update Method
	String updateEmpDesignation(EmpDesignationDTO designation, Integer id) throws Exception;

	String updateOrderNo(Integer id, Integer newOrderNo) throws Exception;

	// Create Method
	String createEmpDesignation(EmpDesignationDTO designation);

	// Delete Method
	String deleteEmpDesignation(Integer id);


}
