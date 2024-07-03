package com.desidoc.management.users.admin.service.emp;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desidoc.management.employee.dto.EmpMasterDTO;
import com.desidoc.management.employee.model.EmpMaster;
import com.desidoc.management.employee.projections.empDetails.EmployeeDetailsProjection;
import com.desidoc.management.employee.projections.empmaster.EmpMasterProjection;

public interface EmpMasterService {

	// Find methods
	EmpMaster findEmpMasterById(Integer id);
	
	EmployeeDetailsProjection findEmpProjectionById(Integer id);

	List<EmpMasterDTO> findAllEmpMasterByLabId(Integer labId);

	List<EmpMasterDTO> findAllEmpMaster();

	List<EmpMasterDTO> findAllEmpMasterByDeleted();
	
	Page<EmpMasterProjection> findAllEmpMasterProjection(Map<String, String> filters, Pageable page);

	// Search method
	Page<EmpMasterProjection> searchEmpMaster(String search, Map<String, String> filters, Pageable page);

	//Update methods
	String updateEmpMaster(EmpMasterDTO empMaster, Integer id) throws Exception;

	String updateViewingOrder(Integer id, String order) throws Exception;

	//Create Method
	Integer createEmpMaster(EmpMasterDTO empMaster) throws Exception;

	//Delete Method
	String deleteEmpMaster(Integer id) throws Exception;


}
