package com.desidoc.management.users.admin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.users.admin.service.AdminService;

@RestController
@RequestMapping("/user")
public class AdminController {
	
	@Autowired
	AdminService service;

	@GetMapping
	String helloWorld() {

		return "hello world";
	}
	
	@GetMapping("/ed")
	ResponseEntity<List<EmpDesignation>> getAllEmpDesignation(){
		return ResponseEntity.ok(service.getAllEmpDesignation());
	}
	
	

}
