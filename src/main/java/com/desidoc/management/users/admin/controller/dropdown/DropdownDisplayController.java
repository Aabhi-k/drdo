package com.desidoc.management.users.admin.controller.dropdown;

import com.desidoc.management.others.projection.DropdownProjection;
import com.desidoc.management.users.admin.service.dropdown.DropdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dropdown/get")
public class DropdownDisplayController {

    @Autowired
    DropdownService service;

    // -------- Displaying Values --------

    @GetMapping("/designation/{id}")
    ResponseEntity<DropdownProjection> getEmpDesignationById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getEmpDesignationById(id));
    }
    @GetMapping("/role/{id}")
    ResponseEntity<DropdownProjection> getEmpRoleById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getEmpRoleById(id));
    }
    @GetMapping("/lab/{id}")
    ResponseEntity<DropdownProjection> getLabMasterById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getLabMasterById(id));
    }
    @GetMapping("/lab/category/{id}")
    ResponseEntity<DropdownProjection> getLabCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getLabCategoryById(id));
    }
    @GetMapping("/lab/cluster/{id}")
    ResponseEntity<DropdownProjection> getLabClusterById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getLabClusterById(id));
    }
    @GetMapping("/emp/mail/category/{id}")
    ResponseEntity<DropdownProjection> getMailCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getMailCategoryById(id));
    }
    @GetMapping("/telephone/category/{id}")
    ResponseEntity<DropdownProjection> getTelephoneCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getTelephoneCategoryById(id));
    }
    @GetMapping("/city/{id}")
    ResponseEntity<DropdownProjection> getCityById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCityById(id));
    }
    @GetMapping("/zipcode/{id}")
    ResponseEntity<DropdownProjection> getZipcodeById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getZipcodeById(id));
    }
}
