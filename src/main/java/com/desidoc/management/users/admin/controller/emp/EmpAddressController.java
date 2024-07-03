package com.desidoc.management.users.admin.controller.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desidoc.management.employee.dto.EmpResidentialAddressDTO;
import com.desidoc.management.employee.projections.empresidentialaddress.EmpResidentialAddressProjection;
import com.desidoc.management.users.admin.service.emp.EmpResidentialAddressService;

@RestController
@RequestMapping("/api/address")
public class EmpAddressController {
	
	
	
	@Autowired
	EmpResidentialAddressService service;
	
	// GET Mapping 
	
	@GetMapping("/details/{empId}")
	ResponseEntity<EmpResidentialAddressProjection> getEmpAddressById(@PathVariable Integer empId){
		return ResponseEntity.ok(service.findEmpAddressById(empId));
	}
	
	
	// POST Mapping
	@PostMapping
	ResponseEntity<String> createEmpAddress(@RequestBody EmpResidentialAddressDTO empResDTO){
		return ResponseEntity.ok(service.createEmpAddress(empResDTO));
	}
	
	
	

}
