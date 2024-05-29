package com.desidoc.management.users.admin.service.lab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.lab.model.LabCategory;
import com.desidoc.management.lab.repository.LabCategoryRepository;

@Service
public class LabCategoryServiceImpl implements LabCategoryService{

	@Autowired
	LabCategoryRepository repository;
	
	@Override
	public LabCategory findLabCategoryById(Integer id) {

		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lab Category not found"));
	}

	@Override
	public List<LabCategory> findAllLabCategories() {
		// TODO Auto-generated method stub
		return null;
	}

}
