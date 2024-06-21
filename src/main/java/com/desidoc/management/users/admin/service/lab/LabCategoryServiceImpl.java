package com.desidoc.management.users.admin.service.lab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.lab.model.LabCategory;
import com.desidoc.management.lab.repository.LabCategoryRepository;
import com.desidoc.management.lab.specifications.LabCategorySpecification;
import com.desidoc.management.others.projection.DropDownProjection;

@Service
public class LabCategoryServiceImpl implements LabCategoryService{

	@Autowired
	LabCategoryRepository repository;
	
	@Override
	public LabCategory findLabCategoryById(Integer id) {

		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lab Category not found"));
	}
	
	private DropDownProjection convertToDropDown(LabCategory dto) {
		return new DropDownProjection() {

			@Override
			public Integer getId() {
				
				return dto.getId();
			}

			@Override
			public String getName() {
				return dto.getCatFullName();
			}
			
		};
		
	}

	@Override
	public Page<DropDownProjection> searchLabCategoryDropDown(String query, Pageable pageable) {
		Specification<LabCategory> sp = LabCategorySpecification.seachLabCategory(query);
		return repository.findAll(sp, pageable).map(this::convertToDropDown);
	}

}
