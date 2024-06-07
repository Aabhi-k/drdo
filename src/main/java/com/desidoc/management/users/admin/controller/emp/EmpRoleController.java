package com.desidoc.management.users.admin.controller.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desidoc.management.others.projection.DropDownProjection;
import com.desidoc.management.users.admin.service.emp.EmpRoleService;

@RestController
@RequestMapping("/emp/role")
public class EmpRoleController {
	@Autowired
	EmpRoleService service;
	
	
	@GetMapping("/dropdown/search")
	ResponseEntity<List<DropDownProjection>> searchDropDownProjection(@RequestParam String query){
		return ResponseEntity.ok(service.searchDropDownMenu(query));
	}

}
