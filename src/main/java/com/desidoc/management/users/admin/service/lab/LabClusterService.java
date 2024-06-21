package com.desidoc.management.users.admin.service.lab;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desidoc.management.lab.model.LabCluster;
import com.desidoc.management.others.projection.DropDownProjection;

public interface LabClusterService {
	
	LabCluster findLabClusterById(Integer id);

	Page<DropDownProjection> searchLabCluster(String query, Pageable pageable);

}
