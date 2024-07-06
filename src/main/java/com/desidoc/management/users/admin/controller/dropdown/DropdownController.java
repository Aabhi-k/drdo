package com.desidoc.management.users.admin.controller.dropdown;

import com.desidoc.management.others.projection.DropdownProjection;
import com.desidoc.management.users.admin.service.dropdown.DropdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dropdown")
public class DropdownController {

    private static final String PAGE_SIZE = "5";

    @Autowired
    DropdownService service;

    // ------------ EMP DESIGNATION ------------
    @GetMapping("/emp/designation/search")
    ResponseEntity<?> searchEmpDesignation(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
        try {
            if (query == null || query.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Query parameter cannot be null or empty");
            }

            Pageable pageable = PageRequest.of(page, size);
            Page<DropdownProjection> result = service.searchEmpDesignation(query, pageable);

            if (result.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            // IllegalArgumentException may be thrown by PageRequest.of() if page or size are negative
            return ResponseEntity.badRequest().body("Invalid page or size parameters: " + e.getMessage());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // ----------- EMP ROLE ----------------
    @GetMapping("/emp/role/search")
    public ResponseEntity<?> searchEmpRole(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
        try {
            if (query == null || query.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Query parameter cannot be null or empty");
            }

            Pageable pageable = PageRequest.of(page, size);
            Page<DropdownProjection> result = service.searchEmpRole(query, pageable);

            if (result.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


    // ------------ LAB MASTER ---------------
    @GetMapping("/lab/list/search")
    public ResponseEntity<?> searchLabMaster(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
        try {
            if (query == null || query.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Query parameter cannot be null or empty");
            }

            Pageable pageable = PageRequest.of(page, size);
            Page<DropdownProjection> result = service.searchLabMaster(query, pageable);

            if (result.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


    // ------------ LAB CATEGORY ---------------
    @GetMapping("/lab/category/search")
    public ResponseEntity<?> searchLabCategory(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
        try {
            if (query == null || query.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Query parameter cannot be null or empty");
            }

            Pageable pageable = PageRequest.of(page, size);
            Page<DropdownProjection> result = service.searchLabCategory(query, pageable);

            if (result.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // ------------ LAB CLUSTER --------------
    @GetMapping("/lab/cluster/search")
    public ResponseEntity<?> searchLabCluster(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
        try {
            if (query == null || query.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Query parameter cannot be null or empty");
            }

            Pageable pageable = PageRequest.of(page, size);
            Page<DropdownProjection> result = service.searchLabCluster(query, pageable);

            if (result.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // ------------ MAIL CATEGORY --------------
    @GetMapping("/emp/mail/category/search")
    public ResponseEntity<?> searchMailCategory(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
        try {
            if (query == null || query.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Query parameter cannot be null or empty");
            }

            Pageable pageable = PageRequest.of(page, size);
            Page<DropdownProjection> result = service.searchMailCategory(query, pageable);

            if (result.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // ------------ CITY MASTER --------------
    @GetMapping("/city/search")
    public ResponseEntity<?> searchCityMaster(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
        try {
            if (query == null || query.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Query parameter cannot be null or empty");
            }

            Pageable pageable = PageRequest.of(page, size);
            Page<DropdownProjection> result = service.searchCity(query, pageable);

            if (result.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // ------------- ZIPCODE ----------
    @GetMapping("/zipcode/search")
    public ResponseEntity<?> searchZipcode(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
        try {
            if (query == null || query.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Query parameter cannot be null or empty");
            }

            Pageable pageable = PageRequest.of(page, size);
            Page<DropdownProjection> result = service.searchZipcode(query, pageable);

            if (result.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    // ------------ TELEPHONE CATEGORY ------------
    @GetMapping("/telephone/category/search")
    public ResponseEntity<?> searchTelephoneCategory(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = PAGE_SIZE) int size) {
        try {
            if (query == null || query.trim().isEmpty()) {
                return ResponseEntity.badRequest().body("Query parameter cannot be null or empty");
            }

            Pageable pageable = PageRequest.of(page, size);
            Page<DropdownProjection> result = service.searchTelephoneCategory(query, pageable);

            if (result.isEmpty()) {
                return ResponseEntity.noContent().build();
            }

            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

}
