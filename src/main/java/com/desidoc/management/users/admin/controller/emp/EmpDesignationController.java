package com.desidoc.management.users.admin.controller.emp;

import com.desidoc.management.employee.dto.EmpDesignationDTO;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignProjection;
import com.desidoc.management.users.admin.service.emp.EmpDesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emp/designation")
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

    // Searching in employees
    @GetMapping("/search")
    ResponseEntity<Page<EmpDesignProjection>> searchEmpDesignation(@RequestParam String query,
                                                                   @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(service.searchEmpDesignation(query, pageable));
    }
    // -------- PUT MAPPINGS --------

    // updating the order number of the employee
    @PutMapping("/{id}/order")
    ResponseEntity<String> updateOrderNo(@PathVariable Integer id, @RequestParam Integer newOrderNo) throws Exception {
        service.updateOrderNo(id, newOrderNo);
        return ResponseEntity.ok("Order number updated successfully");
    }

    // updating the employee Designation
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

    // -------- DELTE MAPPINGS -------- FOR {SUPER ADMIN}

    // deleting the employee
    @DeleteMapping("/{empid}")
    ResponseEntity<String> deleteEmpDesignation(@PathVariable Integer empid) {
        return ResponseEntity.ok(service.deleteEmpDesignation(empid));
    }

}
