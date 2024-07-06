package com.desidoc.management.users.admin.controller.dropdown;

import com.desidoc.management.others.projection.DropdownProjection;
import com.desidoc.management.users.admin.service.dropdown.DropdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<DropdownProjection> getEmpDesignationById(@PathVariable Integer id) {
        try {
            // Validate path variable
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }

            // Retrieve employee designation by id
            DropdownProjection designation = service.getEmpDesignationById(id);

            // Check if designation is null to handle case where id doesn't exist
            if (designation == null) {
                return ResponseEntity.notFound().build();
            }

            // Return the designation
            return ResponseEntity.ok(designation);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/role/{id}")
    public ResponseEntity<DropdownProjection> getEmpRoleById(@PathVariable Integer id) {
        try {
            // Validate path variable
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }

            // Retrieve employee role by id
            DropdownProjection role = service.getEmpRoleById(id);

            // Check if role is null to handle case where id doesn't exist
            if (role == null) {
                return ResponseEntity.notFound().build();
            }

            // Return the role
            return ResponseEntity.ok(role);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/lab/{id}")
    public ResponseEntity<DropdownProjection> getLabMasterById(@PathVariable Integer id) {
        try {
            // Validate path variable
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }

            // Retrieve lab master by id
            DropdownProjection labMaster = service.getLabMasterById(id);

            // Check if labMaster is null to handle case where id doesn't exist
            if (labMaster == null) {
                return ResponseEntity.notFound().build();
            }

            // Return the lab master
            return ResponseEntity.ok(labMaster);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/lab/category/{id}")
    public ResponseEntity<DropdownProjection> getLabCategoryById(@PathVariable Integer id) {
        try {
            // Validate path variable
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }

            // Retrieve lab category by id
            DropdownProjection labCategory = service.getLabCategoryById(id);

            // Check if labCategory is null to handle case where id doesn't exist
            if (labCategory == null) {
                return ResponseEntity.notFound().build();
            }

            // Return the lab category
            return ResponseEntity.ok(labCategory);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/lab/cluster/{id}")
    public ResponseEntity<DropdownProjection> getLabClusterById(@PathVariable Integer id) {
        try {
            // Validate path variable
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }

            // Retrieve lab cluster by id
            DropdownProjection labCluster = service.getLabClusterById(id);

            // Check if labCluster is null to handle case where id doesn't exist
            if (labCluster == null) {
                return ResponseEntity.notFound().build();
            }

            // Return the lab cluster
            return ResponseEntity.ok(labCluster);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/emp/mail/category/{id}")
    public ResponseEntity<DropdownProjection> getMailCategoryById(@PathVariable Integer id) {
        try {
            // Validate path variable
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }

            // Retrieve mail category by id
            DropdownProjection mailCategory = service.getMailCategoryById(id);

            // Check if mailCategory is null to handle case where id doesn't exist
            if (mailCategory == null) {
                return ResponseEntity.notFound().build();
            }

            // Return the mail category
            return ResponseEntity.ok(mailCategory);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/telephone/category/{id}")
    public ResponseEntity<DropdownProjection> getTelephoneCategoryById(@PathVariable Integer id) {
        try {
            // Validate path variable
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }

            // Retrieve telephone category by id
            DropdownProjection telephoneCategory = service.getTelephoneCategoryById(id);

            // Check if telephoneCategory is null to handle case where id doesn't exist
            if (telephoneCategory == null) {
                return ResponseEntity.notFound().build();
            }

            // Return the telephone category
            return ResponseEntity.ok(telephoneCategory);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<DropdownProjection> getCityById(@PathVariable Integer id) {
        try {
            // Validate path variable
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }

            // Retrieve city by id
            DropdownProjection city = service.getCityById(id);

            // Check if city is null to handle case where id doesn't exist
            if (city == null) {
                return ResponseEntity.notFound().build();
            }

            // Return the city
            return ResponseEntity.ok(city);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

    @GetMapping("/zipcode/{id}")
    public ResponseEntity<DropdownProjection> getZipcodeById(@PathVariable Integer id) {
        try {
            // Validate path variable
            if (id == null) {
                return ResponseEntity.badRequest().build();
            }

            // Retrieve zipcode by id
            DropdownProjection zipcode = service.getZipcodeById(id);

            // Check if zipcode is null to handle case where id doesn't exist
            if (zipcode == null) {
                return ResponseEntity.notFound().build();
            }

            // Return the zipcode
            return ResponseEntity.ok(zipcode);

        } catch (IllegalArgumentException e) {
            // Handle specific exceptions or validation errors
            return ResponseEntity.badRequest().body(null);

        } catch (Exception e) {
            // Handle any other unexpected exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null);
        }
    }

}
