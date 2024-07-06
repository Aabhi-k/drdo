package com.desidoc.management.users.admin.controller.emp;

import com.desidoc.management.employee.dto.EmpResidentialAddressDTO;
import com.desidoc.management.employee.projections.empresidentialaddress.EmpResidentialAddressProjection;
import com.desidoc.management.users.admin.service.emp.EmpResidentialAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/address")
public class EmpAddressController {


    @Autowired
    EmpResidentialAddressService service;

    // GET Mapping

    // Get address by id
    @GetMapping("/get/{id}")
    ResponseEntity<EmpResidentialAddressDTO> getEmpResidentialAddressById(@PathVariable Integer id) {
        try {
            // Validate path variable
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }

            // Retrieve address by id
            EmpResidentialAddressDTO addressDTO = service.getEmpResidentialAddressDTOById(id);

            // Check if addressDTO is null to handle case where id doesn't exist
            if (addressDTO == null) {
                return ResponseEntity.notFound().build();
            }

            // Return the address
            return ResponseEntity.ok(addressDTO);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    // Getting Employee Address from id
    @GetMapping("/{empId}")
    ResponseEntity<EmpResidentialAddressDTO> getEmpAddress(@PathVariable Integer empId) {
        try {
            // Validate path variable
            if (empId == null) {
                return ResponseEntity.badRequest().build();
            }

            // Retrieve employee address by empId
            EmpResidentialAddressDTO addressDTO = service.findEmpAddressDTOById(empId);

            // Check if addressDTO is null to handle case where empId doesn't exist
            if (addressDTO == null) {
                return ResponseEntity.notFound().build();
            }

            // Return the address
            return ResponseEntity.ok(addressDTO);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    @GetMapping("/details/{empId}")
    ResponseEntity<EmpResidentialAddressProjection> getEmpAddressById(@PathVariable Integer empId) {
        try {
            // Validate path variable
            if (empId == null) {
                return ResponseEntity.badRequest().build();
            }

            // Retrieve employee address details by empId
            EmpResidentialAddressProjection addressProjection = service.findEmpAddressById(empId);

            // Check if addressProjection is null to handle case where empId doesn't exist
            if (addressProjection == null) {
                return ResponseEntity.notFound().build();
            }

            // Return the address details
            return ResponseEntity.ok(addressProjection);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }


    // POST Mapping
    @PostMapping
    ResponseEntity<String> createEmpAddress(@RequestBody EmpResidentialAddressDTO empResDTO) {
        try {
            // Validate request body
            if (empResDTO == null) {
                return ResponseEntity.badRequest().body("Request body cannot be null");
            }

            // Process creation of employee address
            String result = service.createEmpAddress(empResDTO);

            // Return the result of creation
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }


    // Put Mapping
    @PutMapping("/edit/{empId}")
    public ResponseEntity<?> updateEmpAddress(@PathVariable Integer empId, @RequestBody EmpResidentialAddressDTO empResDTO) {
        try {
            // Validate path variable and request body
            if (empId == null || empResDTO == null) {
                return ResponseEntity.badRequest().body("Employee ID and request body cannot be null");
            }

            String result = service.updateEmpAddress(empId, empResDTO);

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


}
