package com.desidoc.management.users.admin.service.emp;

import java.util.List;

import com.desidoc.management.employee.dto.EmpDesignationDTO;
import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignProjection;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignationFullNameProjection;

public interface EmpDesignationService {

	// Find Methods
	EmpDesignation findEmpDesignationById(Integer id);

	List<EmpDesignationDTO> findAllEmpDesignationByOrderNo();

	List<EmpDesignProjection> findAllEmpDesignProjection();

	// Finding individual columns

	List<EmpDesignationDTO> findAllEmpDesignationShortName();

	List<EmpDesignationFullNameProjection> findAllEmpDesignationFullName();

	// Search
	List<EmpDesignProjection> searchEmpDesignation(String search);

	// Update Method
	String updateEmpDesignation(EmpDesignationDTO designation, Integer id) throws Exception;

	String updateOrderNo(Integer id, Integer newOrderNo) throws Exception;

	// Create Method
	String createEmpDesignation(EmpDesignationDTO designation);

	// Delete Method
	String deleteEmpDesignation(Integer id);

}
