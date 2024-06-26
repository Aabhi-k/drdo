package com.desidoc.management.users.admin.controller.emp;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desidoc.management.users.admin.service.emp.EmpRoleService;

@RestController
@RequestMapping("/api/emp/role")
public class EmpRoleController {
	@Autowired
	EmpRoleService service;
	
	// FOR EDITING ROLES IN FUTURE

}
