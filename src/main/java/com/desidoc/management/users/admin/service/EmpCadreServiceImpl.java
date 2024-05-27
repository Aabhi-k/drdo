package com.desidoc.management.users.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidoc.management.employee.model.EmpCadre;
import com.desidoc.management.employee.repository.EmpCadreRepository;

@Service
public class EmpCadreServiceImpl implements EmpCadreService{

	@Autowired
    EmpCadreRepository repository;
	
	@Override
	public EmpCadre findEmpCadreById(Integer cadreId) {
		
		return repository.findById(cadreId).get();
	}

}
