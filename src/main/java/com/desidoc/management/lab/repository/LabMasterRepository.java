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

	
	 @Query("SELECT lm.labAuthName as labAuthName, " +
	           "lm.labShortName as labShortName, " +
	           "lm.labFullName as labFullName, " +
	           "lc.catFullName as catFullName, " +
	           "lcl.clusterFullName as clusterFullName, " +
	           "cm.cityFullName as cityFullName, " +
	           "lm.otherGroup as otherGroup " +
	           "FROM LabMaster lm " +
	           "JOIN lm.labCatId lc " +
	           "JOIN lm.labCityId cm " +
	           "JOIN lm.labClusterId lcl " +
	           "WHERE lm.deleted = '0'")
	Page<LabMasterProjection> findAllLabMaster(Pageable page);


}
