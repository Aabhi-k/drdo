package com.desidoc.management.users.admin.service.others.telephone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.others.telephone.TelephoneCategory;
import com.desidoc.management.others.telephone.TelephoneCategoryRepository;

@Service
public class TelephoneCategoryServiceImpl implements TelephoneCategoryService	{

	@Autowired
	TelephoneCategoryRepository repository;
	
	@Override
	public TelephoneCategory getTelephoneCategoryById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Telephone Category not found"));
	}

}
