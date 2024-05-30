package com.desidoc.management.users.admin.controller.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desidoc.management.employee.projections.empresidentialaddress.EmpResidentialAddressProjection;
import com.desidoc.management.users.admin.service.emp.EmpResidentialAddressService;

@RestController
@RequestMapping("/address")
public class EmpAddressController {
	
	@Autowired
	EmpResidentialAddressService service;
	
	// GET Mapping 
	@GetMapping
	ResponseEntity<List<EmpResidentialAddressProjection>> findAllEmpAddress(){
		return ResponseEntity.ok(service.findAllEmpAddressProjections());
	}
	
	
	

}
