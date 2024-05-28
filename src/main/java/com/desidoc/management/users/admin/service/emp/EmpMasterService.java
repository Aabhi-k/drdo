package com.desidoc.management.users.admin.service.emp;

import java.util.List;

import com.desidoc.management.employee.dto.EmpMasterDTO;
import com.desidoc.management.employee.model.EmpMaster;

public interface EmpMasterService {
	
	List<EmpMasterDTO> findAllEmpMaster();
	
	List<EmpMasterDTO> searchEmpMaster(String search);
	
	List<EmpMasterDTO> findAllEmpMasterByDeleted();
	
	String updateEmpMaster(EmpMasterDTO empMaster, Integer id) throws Exception;
	
	String deleteEmpMaster(Integer id) throws Exception;
	
	EmpMaster findEmpMasterById(Integer id) throws Exception;
	
	String createEmpMaster(EmpMasterDTO empMaster) throws Exception;

	String updateViewingOrder(Integer id, String order) throws Exception;

}