package com.desidoc.management.users.admin.service.emp;

import java.util.List;

import com.desidoc.management.employee.dto.EmpMasterDTO;
import com.desidoc.management.employee.model.EmpMaster;
import com.desidoc.management.employee.projections.empmaster.EmpMasterProjection;

public interface EmpMasterService {

	// Find methods
	EmpMaster findEmpMasterById(Integer id);

	List<EmpMasterDTO> findAllEmpMasterByLabId(Integer labId);

	List<EmpMasterDTO> findAllEmpMaster();

	List<EmpMasterDTO> findAllEmpMasterByDeleted();
	
	List<EmpMasterProjection> findAllEmpMasterProjection();

	// Search method
	List<EmpMasterProjection> searchEmpMaster(String search);

	//Update methods
	String updateEmpMaster(EmpMasterDTO empMaster, Integer id) throws Exception;

	String updateViewingOrder(Integer id, String order) throws Exception;

	//Create Method
	String createEmpMaster(EmpMasterDTO empMaster) throws Exception;

	//Delete Method
	String deleteEmpMaster(Integer id) throws Exception;


}
