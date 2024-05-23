package com.desidoc.management.users.admin.service;

import java.util.List;

import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.model.EmpMaster;

public interface AdminService {
	
	List<EmpMaster> getAllEmpMaster();

	List<EmpDesignation> getAllEmpDesignation();

}
