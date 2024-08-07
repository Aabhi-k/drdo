package com.desidoc.management.users.admin.controller.emp;

import com.desidoc.management.employee.dto.EmpMailMasterDTO;
import com.desidoc.management.users.admin.service.emp.EmpMailMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emp/mail")
public class EmpMailMasterController {

    @Autowired
    EmpMailMasterService service;

    // -------- GET Mapping --------

    // Getting mail by id
    @GetMapping("/{id}")
    public ResponseEntity<List<EmpMailMasterDTO>> getEmpMailById(@PathVariable Integer id) {
        try {
            // Validate path variable
            if (id == null) {
                return ResponseEntity.badRequest().body(null); // Handle invalid ID
            }

            // Invoke service method to retrieve employee mail by ID
            List<EmpMailMasterDTO> empMailList = service.findEmpMailDTOById(id);

            // Check if employee mail list is empty
            if (empMailList.isEmpty()) {
                return ResponseEntity.noContent().build(); // Return 204 No Content if no data found
            }

            // Return list of employee mail DTOs
            return ResponseEntity.ok(empMailList);

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Or provide an appropriate error message
        }
    }


}
