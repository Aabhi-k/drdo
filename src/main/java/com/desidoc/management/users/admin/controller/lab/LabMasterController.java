package com.desidoc.management.users.admin.controller.lab;

import com.desidoc.management.lab.dto.*;
import com.desidoc.management.lab.projections.labDetails.LabDetailsProjection;
import com.desidoc.management.lab.projections.labmaster.LabMasterProjection;
import com.desidoc.management.users.admin.service.lab.LabDetailsService;
import com.desidoc.management.users.admin.service.lab.LabMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/lab")
public class LabMasterController {

    //Default page size of a page
    private static final String PAGE_SIZE = "10";

    @Autowired
    LabMasterService service;

    @Autowired
    LabDetailsService labDetailsService;

    // GET Mapping

    @GetMapping
    public ResponseEntity<Page<LabMasterProjection>> findAllLabMaster(
            @RequestParam(required = false) Map<String, String> filters,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = PAGE_SIZE) int size) {
        try {
            // Create pageable request
            Pageable pageable = PageRequest.of(page, size);

            // Invoke service method to fetch all lab masters with filters
            Page<LabMasterProjection> labMasters = service.findAllLabMaster(filters, pageable);

            // Return paginated response
            return ResponseEntity.ok(labMasters);

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Or provide an appropriate error message
        }
    }


    // Searching
    @GetMapping("/search")
    public ResponseEntity<Page<LabMasterProjection>> searchLabMaster(
            @RequestParam String query,
            @RequestParam(required = false) Map<String, String> filters,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = PAGE_SIZE) int size) {
        try {
            // Create pageable request
            Pageable pageable = PageRequest.of(page, size);

            // Invoke service method to search lab masters with query and filters
            Page<LabMasterProjection> searchResults = service.searchLabMaster(query, filters, pageable);

            // Return paginated response
            return ResponseEntity.ok(searchResults);

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Or provide an appropriate error message
        }
    }

    @GetMapping("/details/{id}")
    ResponseEntity<?> getLabDetailsService(@PathVariable Integer id){
        try {
            // Invoke service method to fetch lab details by id
            LabDetailsProjection labDetails = labDetailsService.findLabDetailsById(id);

            // Return response
            return ResponseEntity.ok(labDetails);

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Or provide an appropriate error message
        }
    }

    // POST Mapping

    @PostMapping
    public ResponseEntity<?> createLabMaster(@RequestBody LabDetailRequestDTO labDetailRequestDTO) {
        try {
            // Validate request body
            if (labDetailRequestDTO == null) {
                return ResponseEntity.badRequest().body("Request body cannot be null");
            }
            LabMasterDTO labMasterDTO = labDetailRequestDTO.getLabMasterDTO();
            LabAddressDTO labAddressDTO = labDetailRequestDTO.getLabAddressDTO();
            LabTelephoneMasterDTO labTelephoneMasterDTO = labDetailRequestDTO.getLabTelephoneMasterDTO();
            LabFaxMasterDTO labFaxMasterDTO = labDetailRequestDTO.getLabFaxMasterDTO();
            LabEpabxDTO labEpabxDTO = labDetailRequestDTO.getLabEpabxDTO();

            // Invoke service method to create lab master
            String result = labDetailsService.createLabDetails(labMasterDTO,labAddressDTO, labEpabxDTO, labFaxMasterDTO, labTelephoneMasterDTO);

            // Return success message
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }

    // PUT Mapping

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> updateLabMaster(
            @PathVariable Integer id,
            @RequestBody LabMasterDTO labMasterDTO) {

        try {
            // Validate request body and path variable
            if (labMasterDTO == null) {
                return ResponseEntity.badRequest().body("Request body cannot be null");
            }

            // Invoke service method to update lab master
            String result = service.updateLabMaster(labMasterDTO, id);

            // Check if update was successful
            if ("Updated Successfully!".equals(result)) {
                return ResponseEntity.ok(result);
            } else {
                // Handle case where update operation fails (e.g., id not found)
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }

    // DELETE Mapping FOR {ADMIN}

    @PutMapping("/{id}/del")
    public ResponseEntity<String> deleteLabMaster(@PathVariable Integer id) {
        try {
            // Validate path variable
            if (id == null) {
                return ResponseEntity.badRequest().body("ID cannot be null");
            }

            // Invoke service method to delete lab master
            String result = service.deleteLabMaster(id);

            // Check if deletion was successful
            if ("Deleted Successfully!".equals(result)) {
                return ResponseEntity.ok(result);
            } else {
                // Handle case where deletion operation fails (e.g., id not found)
                return ResponseEntity.notFound().build();
            }

        } catch (Exception e) {
            // Handle any unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An error occurred: " + e.getMessage());
        }
    }

}
