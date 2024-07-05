package com.desidoc.management.users.admin.controller.emp;

import com.desidoc.management.employee.dto.EmpTelephoneMasterDTO;
import com.desidoc.management.users.admin.service.emp.EmpTelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
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
    ResponseEntity<List<EmpTelephoneMasterDTO>> getEmpTelephone(@PathVariable Integer empId) {
        return ResponseEntity.ok(service.findEmpTelephoneDTOById(empId));
    }


    // Inserting a new employee telephone number
    @PostMapping
    ResponseEntity<String> addEmpTelephone(@RequestBody List<EmpTelephoneMasterDTO> empTelephoneMasterDTO) {
        return ResponseEntity.ok(service.createEmpTelephone(empTelephoneMasterDTO));
    }
    // Put Mapping

    @PutMapping("/edit/{empId}")
    public ResponseEntity<?> updateEmpTelephone(@PathVariable Integer empId, @RequestBody List<EmpTelephoneMasterDTO> empTelephoneMasterDTOList) {
        if (empTelephoneMasterDTOList == null || empTelephoneMasterDTOList.isEmpty()) {
            return ResponseEntity.badRequest().body("Request body cannot be null or empty");
        }
        try {
            String result = service.updateEmpTelephone(empId, empTelephoneMasterDTOList);
            if ("Updated Successfully!".equals(result)) {
                return ResponseEntity.ok(result);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("An error occurred: " + e.getMessage());
        }
    }
}
