package com.desidoc.management.users.admin.service;

import java.util.List;

import com.desidoc.management.employee.dto.EmpDesignationDTO;

public interface EmpDesignationService {

	List<EmpDesignationDTO> findAllEmpDesignationByOrderNo();

	String updateEmpDesignation(EmpDesignationDTO designation, Integer id) throws Exception;

	String deleteEmpDesignation(Integer id);

	EmpDesignationDTO findEmpDesignationById(Integer id) throws Exception;

	List<EmpDesignationDTO> searchEmpDesignation(String search);

	String createEmpDesignation(EmpDesignationDTO designation);

	String updateOrderNo(Integer id, Integer newOrderNo);

}
