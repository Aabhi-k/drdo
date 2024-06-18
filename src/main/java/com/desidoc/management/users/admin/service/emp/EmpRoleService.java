package com.desidoc.management.users.admin.service.emp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desidoc.management.employee.model.EmpRole;
import com.desidoc.management.others.projection.DropDownProjection;

public interface EmpRoleService {
	EmpRole findEmpRoleById(Integer id);
	
	// searching
	
	Page<DropDownProjection> searchDropDownMenu(String query, Pageable pageable);

}
