package com.desidoc.management.users.admin.controller.dropdown;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desidoc.management.others.projection.DropdownProjection;
import com.desidoc.management.users.admin.service.dropdown.DropdownService;

@RestController
@RequestMapping("/api/dropdown")
public class DropdownController {

	private static final String PAGE_SIZE = "5";

	@Autowired
	DropdownService service;

	// ------------ LAB MASTER ---------------
	@GetMapping("/lab/list/search")
	ResponseEntity<Page<DropdownProjection>> searchLabMaster(@RequestParam String query,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.searchLabMaster(query, pageable));
	}

	// ------------ LAB CATEGORY ---------------
	@GetMapping("/lab/category/search")
	ResponseEntity<Page<DropdownProjection>> searchLabCategory(@RequestParam String query,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.searchLabCategory(query, pageable));
	}

	// ------------ LAB CLUSTER --------------
	@GetMapping("/lab/cluster/search")
	ResponseEntity<Page<DropdownProjection>> searchLabCluster(@RequestParam String query,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.searchLabCluster(query, pageable));
	}

	// ------------ CITY MASTER --------------
	@GetMapping("/city/search")
	ResponseEntity<Page<DropdownProjection>> searchCityMaster(@RequestParam String query,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.searchCity(query, pageable));
	}

	// ------------ EMP DESIGNATION ------------
	@GetMapping("/emp/designation/search")
	ResponseEntity<Page<DropdownProjection>> searchEmpDesignation(@RequestParam String query,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.searchEmpDesignation(query, pageable));
	}

	// ----------- EMP ROLE ----------------
	@GetMapping("/emp/role/search")
	ResponseEntity<Page<DropdownProjection>> searchEmpRole(@RequestParam String query,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.searchEmpRole(query, pageable));
	}
	
	// ------------- ZIPCODE ----------
	@GetMapping("/zipcode/search")
	ResponseEntity<Page<DropdownProjection>> searchZipcode(@RequestParam String query,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.searchZipcode(query, pageable));
	}
}
