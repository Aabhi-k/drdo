package com.desidoc.management.users.admin.controller.emp;

import com.desidoc.management.employee.dto.EmpTelephoneMasterDTO;
import com.desidoc.management.users.admin.service.emp.EmpTelephoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/emp/telephone")
public class EmpTelephoneController {

    @Autowired
    EmpTelephoneService service;

    // GET Mapping

    // Getting Employee Telephone number from id
    @GetMapping("/{empId}")
    ResponseEntity<EmpTelephoneMasterDTO> getEmpTelephone(@PathVariable Integer empId) {
        return ResponseEntity.ok(service.findEmpTelephoneDTOById(empId));
    }


    // Inserting a new employee telephone number
    @PostMapping
    ResponseEntity<String> addEmpTelephone(@RequestBody EmpTelephoneMasterDTO empTelephoneMasterDTO) {
        return ResponseEntity.ok(service.createEmpTelephone(empTelephoneMasterDTO));
    }
    // Put Mapping
    
}
