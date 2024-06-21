package com.desidoc.management.users.admin.service.lab;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desidoc.management.lab.model.LabCategory;
import com.desidoc.management.others.projection.DropDownProjection;

public interface LabCategoryService {

	LabCategory findLabCategoryById(Integer id);
	Page<DropDownProjection> searchLabCategoryDropDown(String query, Pageable pageable);
}
