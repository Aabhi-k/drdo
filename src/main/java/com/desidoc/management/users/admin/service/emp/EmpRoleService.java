package com.desidoc.management.users.admin.service.emp;

import java.util.List;

import com.desidoc.management.employee.model.EmpRole;
import com.desidoc.management.others.projection.DropDownProjection;

public interface EmpRoleService {
	EmpRole findEmpRoleById(Integer id);
	
	// searching
	
	List<DropDownProjection> searchDropDownMenu(String query);

}
