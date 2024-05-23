package com.desidoc.management.users.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.repository.EmpDesignationRepository;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	EmpDesignationRepository empDesignationRepository;

	@Override
	public List<EmpDesignation> getAllEmpDesignation() {
		return empDesignationRepository.findAll();
		
	}
	
	

}
