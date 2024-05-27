package com.desidoc.management.users.admin.service;

import java.util.List;

import com.desidoc.management.employee.dto.EmpMasterDTO;

public interface EmpMasterService {
	
	List<EmpMasterDTO> findAllEmpMaster();
	
	List<EmpMasterDTO> searchEmpMaster(String search);
	
	List<EmpMasterDTO> findAllEmpMasterByDeleted();
	
	String updateEmpMaster(EmpMasterDTO empMaster, Integer id) throws Exception;
	
	String deleteEmpMaster(Integer id) throws Exception;
	
	EmpMasterDTO getEmpMasterById(Integer id) throws Exception;
	
	String createEmpMaster(EmpMasterDTO empMaster);

	String updateViewingOrder(Integer id, String order) throws Exception;

}
