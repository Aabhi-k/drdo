package com.desidoc.management.users.admin.controller.emp;

import com.desidoc.management.employee.dto.EmpMailMasterDTO;
import com.desidoc.management.users.admin.service.emp.EmpMailMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/emp/mail")
public class EmpMailMasterController {

    @Autowired
    EmpMailMasterService service;

    // -------- GET Mapping --------

    // Getting mail by id
    @GetMapping("/{id}")
    ResponseEntity<List<EmpMailMasterDTO>> getEmpMailById(Integer id) {
        return ResponseEntity.ok(service.findEmpMailDTOById(id));
    }

    // POST Mapping

    // Inserting a new employee mail
    @PostMapping
    ResponseEntity<String> addEmpMail(List<EmpMailMasterDTO> empMailMasterDtoList) {
        return ResponseEntity.ok(service.createEmpMail(empMailMasterDtoList));
    }
}
