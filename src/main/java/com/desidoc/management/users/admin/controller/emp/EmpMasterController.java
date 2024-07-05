package com.desidoc.management.users.admin.controller.emp;

import com.desidoc.management.employee.dto.EmpMasterDTO;
import com.desidoc.management.employee.projections.empDetails.EmployeeDetailsProjection;
import com.desidoc.management.employee.projections.empmaster.EmpMasterProjection;
import com.desidoc.management.users.admin.service.emp.EmpMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/emp/list")
public class EmpMasterController {

    // Default size of page
    private static final String PAGE_SIZE = "10";

    @Autowired
    EmpMasterService service;

    // -------- GET MAPPINGS --------
    // Getting Employee Master from id
    @GetMapping("/{empId}")
    ResponseEntity<EmpMasterDTO> findEmpMaster(@PathVariable Integer empId) {
        return ResponseEntity.ok(service.findEmpMasterDTOById(empId));
    }

    // Getting Employee Details from id
    @GetMapping("/details/{empId}")
    ResponseEntity<EmployeeDetailsProjection> findEmpById(@PathVariable Integer empId) {
        return ResponseEntity.ok(service.findEmpProjectionById(empId));
    }

    // Getting all Employees
    @GetMapping
    ResponseEntity<Page<EmpMasterProjection>> findAllEmpMaster(
            @RequestParam(required = false) Map<String, String> filters,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = PAGE_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(service.findAllEmpMasterProjection(filters, pageable));
    }


    // Searching in Employees
    @GetMapping("/search")
    ResponseEntity<Page<EmpMasterProjection>> searchEmpMaster(
            @RequestParam String query,
            @RequestParam(required = false) Map<String, String> filters,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = PAGE_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(service.searchEmpMaster(query, filters, pageable));
    }


    // -------- PUT MAPPINGS --------

    // updating the employee
    @PutMapping("/edit/{empId}")
    ResponseEntity<String> updateEmpMaster(@RequestBody EmpMasterDTO dto, @PathVariable Integer empId) throws Exception {
        if(dto == null) {
            return ResponseEntity.badRequest().body("Request body cannot be null");
        }
        try {
            String result = service.updateEmpMaster(dto, empId);
            if ("Updated Successfully!".equals(result)) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred: " + e.getMessage());
        }
    }

    // updating the employee order number
    @PutMapping("/order/{empId}")
    ResponseEntity<String> updateOrderNo(@PathVariable Integer empId, @RequestParam String order) throws Exception {

        return ResponseEntity.ok(service.updateViewingOrder(empId, order));
    }

    // -------- POST MAPPINGS --------

    // creating the employee
    @PostMapping
    ResponseEntity<Integer> createEmpMaster(@RequestBody EmpMasterDTO empMaster) throws Exception {

        return ResponseEntity.ok(service.createEmpMaster(empMaster));
    }

    // -------- DELTE MAPPINGS -------- FOR {ADMIN}

    // deleting the employee
    @PutMapping("/{empId}/del")
    ResponseEntity<String> deleteEmpMaster(@PathVariable Integer empId) throws Exception {
        return ResponseEntity.ok(service.deleteEmpMaster(empId));
    }


}
