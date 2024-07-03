package com.desidoc.management.users.admin.service.dropdown;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desidoc.management.others.projection.DropdownProjection;

public interface DropdownService {

	Page<DropdownProjection> searchLabMaster(String query, Pageable page);
	Page<DropdownProjection> searchLabCategory(String query, Pageable pageable);
	Page<DropdownProjection> searchLabCluster(String query, Pageable pageable);
	Page<DropdownProjection> searchCity(String query, Pageable pageable);
	Page<DropdownProjection> searchEmpDesignation(String query, Pageable page);
	Page<DropdownProjection> searchEmpRole(String query, Pageable page);
	Page<DropdownProjection> searchZipcode(String query, Pageable pageable);
}
