package com.desidoc.management.users.admin.controller.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.desidoc.management.lab.dto.LabMasterDTO;
import com.desidoc.management.lab.model.LabMaster;
import com.desidoc.management.lab.projections.labmaster.LabMasterProjection;
import com.desidoc.management.users.admin.service.lab.LabMasterService;

@RestController
@RequestMapping("/lab")
public class LabMasterController {
	
	//Default page size of a page
	private static final String PAGE_SIZE = "10";

	@Autowired
	LabMasterService service;

	// GET Mapping

	@GetMapping
	ResponseEntity<Page<LabMasterProjection>> fingAllLabMaster(
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = PAGE_SIZE) int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.findAllLabMaster(pageable));
	}

	@GetMapping("/search")
	ResponseEntity<Page<LabMasterProjection>> searchLabMaster(
			@RequestParam String query,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = PAGE_SIZE) int size) {
		Pageable pageable = PageRequest.of(page, size);
		return ResponseEntity.ok(service.searchLabMaster(query, pageable));
	}

	@GetMapping("/{id}")
	ResponseEntity<LabMaster> findLabMasterById(@PathVariable Integer id) throws Exception {
		return ResponseEntity.ok(service.findLabMasterById(id));
	}

	// POST Mapping

	@PostMapping
	ResponseEntity<String> createLabMaster(@RequestBody LabMasterDTO labMasterDTO) throws Exception {
		return ResponseEntity.ok(service.createLabMaster(labMasterDTO));
	}

	// PUT Mapping

	@PutMapping("/{id}")
	ResponseEntity<String> updateLabMaster(@PathVariable Integer id, @RequestBody LabMasterDTO labMasterDTO)
			throws Exception {
		return ResponseEntity.ok(service.updateLabMaster(labMasterDTO, id));
	}

	// DELETE Mapping

	@PutMapping("/{id}/del")
	ResponseEntity<String> deleteLabMaster(@PathVariable Integer id) throws Exception {
		return ResponseEntity.ok(service.deleteLabMaster(id));
	}
}
