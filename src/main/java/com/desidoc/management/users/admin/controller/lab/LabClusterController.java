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

import com.desidoc.management.others.projection.DropDownProjection;
import com.desidoc.management.users.admin.service.lab.LabClusterService;

@RestController
@RequestMapping("/api/lab/cluster")
public class LabClusterController {
	
	@Autowired
	LabClusterService service;
	
	@GetMapping("/dropdown/search")
	ResponseEntity<Page<DropDownProjection>> searchLabClusterDropDown(
			@RequestParam String query,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
            ){
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.searchLabCluster(query, pageable));
		
	}

}
