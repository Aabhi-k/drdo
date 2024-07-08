package com.desidoc.management.users.admin.controller.emp;

import com.desidoc.management.employee.dto.EmpResidentialAddressDTO;
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


}
