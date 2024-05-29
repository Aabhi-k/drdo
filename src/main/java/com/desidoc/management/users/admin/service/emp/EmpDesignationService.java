package com.desidoc.management.users.admin.service.emp;

import java.util.List;

import com.desidoc.management.employee.dto.EmpDesignationDTO;
import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignAndCadre;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignationFullNameProjection;

public interface EmpDesignationService {

	String updateEmpDesignation(EmpDesignationDTO designation, Integer id) throws Exception;

	String deleteEmpDesignation(Integer id);

	EmpDesignation findEmpDesignationById(Integer id) throws Exception;

	List<EmpDesignationDTO> searchEmpDesignation(String search);

	String createEmpDesignation(EmpDesignationDTO designation);

	String updateOrderNo(Integer id, Integer newOrderNo) throws Exception;
	
	List<EmpDesignationDTO> findAllEmpDesignationByOrderNo();
	
	//Finding individual columns
	List<EmpDesignAndCadre> getAllEmpDesignAndCadre();
	
	List<EmpDesignationDTO> getAllEmpDesignationShortName();
	
	List<EmpDesignationFullNameProjection> getAllEmpDesignationFullName();
    
    
    
    
    

}
