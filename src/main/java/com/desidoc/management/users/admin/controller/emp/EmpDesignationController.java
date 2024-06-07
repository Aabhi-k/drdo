package com.desidoc.management.users.admin.controller.emp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desidoc.management.employee.dto.EmpDesignationDTO;
import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignProjection;
import com.desidoc.management.others.projection.DropDownProjection;
import com.desidoc.management.users.admin.service.emp.EmpDesignationService;

@RestController
@RequestMapping("/emp/ed")
public class EmpDesignationController {

	// Default size of each page
	private static final String PAGE_SIZE = "10";

	@Autowired
	EmpDesignationService service;

	// -------- GET MAPPINGS --------

	// Getting all employees
	@GetMapping
	ResponseEntity<Page<EmpDesignProjection>> findAllEmpDesignationByOrderNo(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = PAGE_SIZE) int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.findAllEmpDesignProjection(pageable));
	}

	// finding all employees by id
	@GetMapping("/{empId}")
	ResponseEntity<EmpDesignation> findEmpDesignationById(@PathVariable Integer empId) {
		System.out.println(empId);
		return ResponseEntity.ok(service.findEmpDesignationById(empId));
	}

	@GetMapping("/dropdown")
	ResponseEntity<List<DropDownProjection>> getAllEmpDesignationFullName() {
		return ResponseEntity.ok(service.findAllForDropDown());
	}

	// Searching in employees
	@GetMapping("/search")
	ResponseEntity<Page<EmpDesignProjection>> searchEmpDesignation(@RequestParam String query,
			@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {

		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.searchEmpDesignation(query, pageable));
	}
	@GetMapping("/dropdown/search")
	ResponseEntity<List<DropDownProjection>> searchAllEmpDesignationDropDown(@RequestParam String query){
		
		return ResponseEntity.ok(service.searchEmpDesignationDropDown(query));
	}
	
	// -------- PUT MAPPINGS --------

	// updating the order number of the employee
	@PutMapping("/{id}/order")
	ResponseEntity<String> updateOrderNo(@PathVariable Integer id, @RequestParam Integer newOrderNo) throws Exception {
		service.updateOrderNo(id, newOrderNo);
		return ResponseEntity.ok("Order number updated successfully");
	}

	// updating the employee
	@PutMapping("/{empId}")
	ResponseEntity<String> updateEmpDesignation(@RequestBody EmpDesignationDTO empDesignation,
			@PathVariable Integer empId) throws Exception {

		return ResponseEntity.ok(service.updateEmpDesignation(empDesignation, empId));
	}

	// -------- POST MAPPINGS --------

	// creating the employee
	@PostMapping
	ResponseEntity<String> createEmpDesignation(@RequestBody EmpDesignationDTO empDesignation) {
		return ResponseEntity.ok(service.createEmpDesignation(empDesignation));
	}

	// -------- DELTE MAPPINGS --------

	// deleting the employee
	@DeleteMapping("/{empid}")
	ResponseEntity<String> deleteEmpDesignation(@PathVariable Integer empid) {
		return ResponseEntity.ok(service.deleteEmpDesignation(empid));
	}

}
