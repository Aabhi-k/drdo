package com.desidoc.management.users.admin.service.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.lab.model.LabCluster;
import com.desidoc.management.lab.repository.LabClusterRepository;

@Service
public class LabClusterServiceImpl implements LabClusterService{

	@Autowired
	LabClusterRepository repository;
	
	
	@Override
	public LabCluster findLabClusterById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lab Cluster not found"));
	}



}
