package com.desidoc.management.users.admin.controller.emp;

import com.desidoc.management.employee.dto.*;
import com.desidoc.management.employee.projections.empDetails.EmployeeDetailsProjection;
import com.desidoc.management.employee.projections.empmaster.EmpMasterProjection;
import com.desidoc.management.users.admin.service.emp.EmpDetailsService;
import com.desidoc.management.users.admin.service.emp.EmpMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/emp/list")
public class EmpMasterController {

    // Default size of page
    private static final String PAGE_SIZE = "10";

    @Autowired
    EmpMasterService service;
    @Autowired
    EmpDetailsService empDetailsService;

    // -------- GET MAPPINGS --------
    // Getting Employee Master from id
    @GetMapping("/{empId}")
    public ResponseEntity<?> findEmpMaster(@PathVariable Integer empId) {
        try {
            // Perform null check if necessary (depending on how Spring handles path variables)
            if (empId == null) {
                return ResponseEntity.badRequest().build();
            }

            EmpMasterDTO empMasterDTO = service.findEmpMasterDTOById(empId);

            // Check if empMasterDTO is null to handle case where empId doesn't exist
            if (empMasterDTO == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(empMasterDTO);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve employee details: " + e.getMessage());
        }
    }

    // Getting Employee Details from id
    @GetMapping("/details/{empId}")
    ResponseEntity<?> findEmpDetailsById(@PathVariable Integer empId) {
        try {
            // Perform null check if necessary (depending on how Spring handles path variables)
            if (empId == null) {
                return ResponseEntity.badRequest().build();
            }
            EmployeeDetailsProjection empDetails = empDetailsService.findEmpDetailsById(empId);

            // Check if empDetails is null to handle case where empId doesn't exist
            if (empDetails == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(empDetails);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve employee details: " + e.getMessage());
        }
    }

    // Getting all Employees
    @GetMapping
    public ResponseEntity<?> findAllEmpMaster(@RequestParam(required = false) Map<String, String> filters, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {

        try {
            // Initialize Pageable for pagination
            Pageable pageable = PageRequest.of(page, size);

            // Perform null check for filters map
            if (filters == null) {
                filters = new HashMap<>();
            }
            // Retrieve data based on filters and pagination
            Page<EmpMasterProjection> empMasters = service.findAllEmpMasterProjection(filters, pageable);

            // Check if empMasters is empty to return noContent response
            if (empMasters.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(empMasters);

        } catch (IllegalArgumentException e) {
            // Handle invalid filter values or other IllegalArgumentExceptions
            return ResponseEntity.badRequest().body("Invalid request parameters: " + e.getMessage());

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve employee master list: " + e.getMessage());
        }
    }


    // Searching in Employees
    @GetMapping("/search")
    public ResponseEntity<?> searchEmpMaster(
            @RequestParam String query,
            @RequestParam(required = false) Map<String, String> filters,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = PAGE_SIZE) int size) {

        try {
            // Validate query parameter
            if (query == null || query.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Query parameter cannot be null or empty");
            }

            // Initialize Pageable for pagination
            Pageable pageable = PageRequest.of(page, size);

            // Perform null check for filters map
            if (filters == null) {
                filters = new HashMap<>();
            }

            // Retrieve data based on query, filters, and pagination
            Page<EmpMasterProjection> empMasters = service.searchEmpMaster(query, filters, pageable);

            // Check if empMasters is empty to return noContent response
            if (empMasters.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            // Return paginated list of empMasters
            return ResponseEntity.ok(empMasters);

        } catch (IllegalArgumentException e) {
            // Handle invalid query or filter values
            return ResponseEntity.badRequest().body("Invalid request parameters: " + e.getMessage());

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to search employee master list: " + e.getMessage());
        }
    }


    // -------- PUT MAPPINGS --------

    // updating the employee
    @PutMapping("/edit/{empId}")
    public ResponseEntity<String> updateEmpMaster(@RequestBody CreateEmpRequest createEmpRequest, @PathVariable Integer empId) {
        try {
            // Validate request body
            if (createEmpRequest == null) {
                return ResponseEntity.badRequest().body("Request body cannot be null");
            }
            EmpMasterDTO empMasterDTO = createEmpRequest.getEmpMaster();
            List<EmpTelephoneMasterDTO> empTelephoneMasterDTOs = createEmpRequest.getEmpTelephoneMasterDTOs();
            List<EmpMailMasterDTO> empMailMasterDTOs = createEmpRequest.getEmpMailMasterDTOs();
            EmpResidentialAddressDTO empResidentialAddressDTO = createEmpRequest.getEmpResidentialAddressDTO();

            // Perform update operation
            String result = empDetailsService.updateEmpDetails(empId, empMasterDTO, empTelephoneMasterDTOs, empMailMasterDTOs, empResidentialAddressDTO);

            // Check result and return appropriate response
            if ("Updated Successfully!".equals(result)) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body("Invalid request parameters: " + e.getMessage());

        } catch (NoSuchElementException e) {
            // Handle case where empId does not exist
            return ResponseEntity.notFound().build();

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update employee details: " + e.getMessage());
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
    public ResponseEntity<?> createEmpMaster(@RequestBody CreateEmpRequest createEmpRequest) {
        try {
            // Validate request body
            if (createEmpRequest == null) {
                return ResponseEntity.badRequest().body("Request body data cannot be null");
            }

            // Extract values from createEmpRequest
            EmpMasterDTO empMasterDTO = createEmpRequest.getEmpMaster();
            List<EmpTelephoneMasterDTO> empTelephoneMasterDTOs = createEmpRequest.getEmpTelephoneMasterDTOs();
            List<EmpMailMasterDTO> empMailMasterDTOs = createEmpRequest.getEmpMailMasterDTOs();
            EmpResidentialAddressDTO empResidentialAddressDTO = createEmpRequest.getEmpResidentialAddressDTO();

            // Perform creation operation
            String result = empDetailsService.createEmpDetails(empMasterDTO, empTelephoneMasterDTOs, empMailMasterDTOs, empResidentialAddressDTO);

            // Return the result of the creation operation
            return ResponseEntity.ok(result);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body("Invalid request parameters: " + e.getMessage());

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred during employee creation: " + e.getMessage());
        }
    }


    // -------- DELETE MAPPINGS -------- FOR {ADMIN}

    // deleting the employee
    @PutMapping("/del/{empId}")
    public ResponseEntity<String> deleteEmpMaster(@PathVariable Integer empId) {
        try {
            // Perform deletion operation
            String deletionResult = service.deleteEmpMaster(empId);

            // Check deletion result and return appropriate response
            if ("Deleted Successfully".equals(deletionResult)) {
                return ResponseEntity.ok(deletionResult);
            } else {
                return ResponseEntity.notFound().build();
            }

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body("Invalid request parameters: " + e.getMessage());

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to delete employee: " + e.getMessage());
        }
    }


}
