package com.desidoc.management.users.admin.controller.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desidoc.management.others.projection.DropdownProjection;
import com.desidoc.management.users.admin.service.lab.LabCategoryService;

@RestController
@RequestMapping("/api/lab/category")
public class LabCategoryController {
	@Autowired
    private LabCategoryService service;
	
	// FOR EDITING CATEGORY

}
