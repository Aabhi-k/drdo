package com.desidoc.management.users.admin.controller.emp;

import com.desidoc.management.employee.dto.EmpDesignationDTO;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignProjection;
import com.desidoc.management.users.admin.service.emp.EmpDesignationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<Page<EmpDesignProjection>> findAllEmpDesignationByOrderNo(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = PAGE_SIZE) int size) {

        try {
            // Create pageable object for pagination
            Pageable pageable = PageRequest.of(page, size);

            // Retrieve paginated list of employee designations ordered by OrderNo
            Page<EmpDesignProjection> empDesignationsPage = service.findAllEmpDesignProjection(pageable);

            // Return paginated list as ResponseEntity
            return ResponseEntity.ok(empDesignationsPage);

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Or provide an appropriate error message
        }
    }


    // Searching in employees
    @GetMapping("/search")
    public ResponseEntity<Page<EmpDesignProjection>> searchEmpDesignation(
            @RequestParam String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = PAGE_SIZE) int size) {

        try {
            // Validate query parameter
            if (query == null || query.trim().isEmpty()) {
                return ResponseEntity.badRequest().body(null); // Handle invalid query parameter
            }

            // Create pageable object for pagination
            Pageable pageable = PageRequest.of(page, size);

            // Retrieve paginated list of employee designations based on search query
            Page<EmpDesignProjection> empDesignationsPage = service.searchEmpDesignation(query, pageable);

            // Return paginated list as ResponseEntity
            return ResponseEntity.ok(empDesignationsPage);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null); // Or provide an appropriate error message

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Or provide an appropriate error message
        }
    }

    // -------- PUT MAPPINGS --------

    // updating the order number of the employee
    @PutMapping("/{id}/order")
    public ResponseEntity<String> updateOrderNo(
            @PathVariable Integer id,
            @RequestParam Integer newOrderNo) {

        try {
            // Validate path variable and request parameter
            if (id == null || newOrderNo == null) {
                return ResponseEntity.badRequest().body("ID and newOrderNo cannot be null");
            }

            // Invoke service method to update order number
            service.updateOrderNo(id, newOrderNo);

            // Return success message
            return ResponseEntity.ok("Order number updated successfully");

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body("Invalid ID or newOrderNo");

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }


    // updating the employee Designation
    @PutMapping("/{empId}")
    public ResponseEntity<String> updateEmpDesignation(
            @RequestBody EmpDesignationDTO empDesignation,
            @PathVariable Integer empId) {

        try {
            // Validate path variable and request body
            if (empDesignation == null) {
                return ResponseEntity.badRequest().body("Request body cannot be null");
            }

            // Invoke service method to update employee designation
            String result = service.updateEmpDesignation(empDesignation, empId);

            // Check if update was successful
            if ("Updated Successfully!".equals(result)) {
                return ResponseEntity.ok(result);
            } else {
                // Handle case where update operation fails (e.g., empId not found)
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }


    // -------- POST MAPPINGS --------

    // creating the employee
    @PostMapping
    public ResponseEntity<String> createEmpDesignation(
            @RequestBody EmpDesignationDTO empDesignation) {

        try {
            // Validate request body
            if (empDesignation == null) {
                return ResponseEntity.badRequest().body("Request body cannot be null");
            }

            // Invoke service method to create employee designation
            String result = service.createEmpDesignation(empDesignation);

            // Return success message
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }


    // -------- DELETE MAPPINGS -------- FOR {SUPER ADMIN}

    // deleting the employee
    @DeleteMapping("/{empId}")
    public ResponseEntity<String> deleteEmpDesignation(@PathVariable Integer empId) {

        try {
            // Validate path variable
            if (empId == null) {
                return ResponseEntity.badRequest().body("Employee ID cannot be null");
            }

            // Invoke service method to delete employee designation
            String result = service.deleteEmpDesignation(empId);

            // Check if deletion was successful
            if ("Deleted Successfully!".equals(result)) {
                return ResponseEntity.ok(result);
            } else {
                // Handle case where deletion operation fails (e.g., empId not found)
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }


}
