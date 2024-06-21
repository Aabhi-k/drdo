package com.desidoc.management.lab.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desidoc.management.lab.model.LabMaster;
import com.desidoc.management.lab.projections.labmaster.LabMasterProjection;

@Repository
public interface LabMasterRepository extends JpaRepository<LabMaster, Integer> , JpaSpecificationExecutor<LabMaster>{

	List<LabMaster> findAllByDeleted(String deleted);

	
	


}
