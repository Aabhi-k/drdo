package com.desidoc.management.users.admin.service.lab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.lab.model.LabCluster;
import com.desidoc.management.lab.repository.LabClusterRepository;
import com.desidoc.management.lab.specifications.LabClusterSpecification;
import com.desidoc.management.others.projection.DropDownProjection;

@Service
public class LabClusterServiceImpl implements LabClusterService{

	@Autowired
	LabClusterRepository repository;
	
	private DropDownProjection convertToDropDown(LabCluster dto) {
		return new DropDownProjection() {

			@Override
			public Integer getId() {
				
				return dto.getId();
			}

			@Override
			public String getName() {
				return dto.getClusterFullName();
			}
			
		};
		
	}
	@Override
	public LabCluster findLabClusterById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Lab Cluster not found"));
	}

	@Override
	public Page<DropDownProjection> searchLabCluster(String query, Pageable pageable) {
		Specification<LabCluster> sp = LabClusterSpecification.searchLabCluster(query);
		return repository.findAll(sp, pageable).map(this::convertToDropDown);
	}

}
