package com.desidoc.management.users.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidoc.management.employee.model.EmpRole;
import com.desidoc.management.employee.repository.EmpRoleRepository;
import com.desidoc.management.exception.EntityNotFoundException;

@Service
public class EmpRoleServiceImpl implements EmpRoleService{
	
	@Autowired
	EmpRoleRepository repository;

	@Override
	public EmpRole findEmpRoleById(Integer id) throws Exception {
		
		return repository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Employee Role not found"));
	}

}
