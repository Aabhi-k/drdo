package com.desidoc.management.users.admin.controller.emp;

import com.desidoc.management.employee.dto.EmpTelephoneMasterDTO;
import com.desidoc.management.users.admin.service.emp.EmpTelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp/telephone")
public class EmpTelephoneController {

    @Autowired
    EmpTelephoneService service;

    // GET Mapping

    // Getting Employee Telephone number from id
    @GetMapping("/{empId}")
    public ResponseEntity<List<EmpTelephoneMasterDTO>> getEmpTelephone(@PathVariable Integer empId) {
        try {
            // Validate path variable
            if (empId == null) {
                return ResponseEntity.badRequest().body(null); // Handle invalid ID
            }

            // Invoke service method to retrieve employee telephone numbers by employee ID
            List<EmpTelephoneMasterDTO> empTelephoneList = service.findEmpTelephoneDTOById(empId);

            // Check if employee telephone list is empty
            if (empTelephoneList.isEmpty()) {
                return ResponseEntity.noContent().build(); // Return 204 No Content if no data found
            }

            // Return list of employee telephone DTOs
            return ResponseEntity.ok(empTelephoneList);

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Or provide an appropriate error message
        }
    }
}
