package com.desidoc.management.users.admin.service.lab;

import java.util.List;

import com.desidoc.management.lab.model.LabCategory;

public interface LabCategoryService {

	LabCategory findLabCategoryById(Integer id);
	List<LabCategory> findAllLabCategories();
}
