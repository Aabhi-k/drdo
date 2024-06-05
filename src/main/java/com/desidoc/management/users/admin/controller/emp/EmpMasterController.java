package com.desidoc.management.users.admin.controller.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desidoc.management.employee.dto.EmpMasterDTO;
import com.desidoc.management.employee.model.EmpMaster;
import com.desidoc.management.employee.projections.empmaster.EmpMasterProjection;
import com.desidoc.management.users.admin.service.emp.EmpMasterService;

@RestController
@RequestMapping("/emp/em")
public class EmpMasterController {
	
	// Default size of page
	private static final String PAGE_SIZE = "10";
	
	@Autowired
	EmpMasterService service;
	
	// -------- GET MAPPINGS --------
	
	// Getting all Employees
	@GetMapping
    ResponseEntity<Page<EmpMasterProjection>> findAllEmpMaster(
    		@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = PAGE_SIZE) int size){
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.findAllEmpMasterProjection(pageable));
	}
	
	// Searching in Employees
	@GetMapping("/search")
    ResponseEntity<Page<EmpMasterProjection>> searchEmpMaster(
    		@RequestParam String query,
    		@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = PAGE_SIZE) int size){
		Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(service.searchEmpMaster(query, pageable));
    }
	
	// finding all Employees by id
	@GetMapping("/{id}")
    ResponseEntity<EmpMaster> findEmpMasterById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(service.findEmpMasterById(id));
    }
	
	// -------- PUT MAPPINGS --------

	// updating the employee
	@PutMapping("/{empId}")
	ResponseEntity<String> updateEmpMaster(@RequestBody EmpMasterDTO empMaster, @PathVariable Integer empId) throws Exception {
        return ResponseEntity.ok(service.updateEmpMaster(empMaster, empId));
    }
	
	// updating the employee order number
	@PutMapping("/{empId}/order")
	ResponseEntity<String> updateOrderNo(@PathVariable Integer empId, @RequestParam String order) throws Exception{
		
        return ResponseEntity.ok(service.updateViewingOrder(empId, order));
	}
	
	// -------- POST MAPPINGS --------

	// creating the employee
	@PostMapping
	ResponseEntity<String> createEmpMaster(@RequestBody EmpMasterDTO empMaster) throws Exception{
        return ResponseEntity.ok(service.createEmpMaster(empMaster));
    }
	
	// -------- DELTE MAPPINGS --------
	
    // deleting the employee
	@PutMapping("/{empid}/del")
    ResponseEntity<String> deleteEmpMaster(@PathVariable Integer empid) throws Exception {
        return ResponseEntity.ok(service.deleteEmpMaster(empid));
    }
	
	
	
	
	
	

}
