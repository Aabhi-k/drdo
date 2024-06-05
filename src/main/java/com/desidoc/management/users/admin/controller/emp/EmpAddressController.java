package com.desidoc.management.users.admin.controller.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desidoc.management.employee.projections.empresidentialaddress.EmpResidentialAddressProjection;
import com.desidoc.management.users.admin.service.emp.EmpResidentialAddressService;

@RestController
@RequestMapping("/address")
public class EmpAddressController {
	
	// Default size of the page
	private static final String PAGE_SIZE = "10";
	
	@Autowired
	EmpResidentialAddressService service;
	
	// GET Mapping 
	@GetMapping
	ResponseEntity<Page<EmpResidentialAddressProjection>> findAllEmpAddress(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = PAGE_SIZE) int size){
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.findAllEmpAddressProjections(pageable));
	}
	
	
	

}
