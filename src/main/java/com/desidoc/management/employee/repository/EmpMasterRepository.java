package com.desidoc.management.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.desidoc.management.employee.model.EmpMaster;
@Repository
public interface EmpMasterRepository extends JpaRepository<EmpMaster, Integer>, JpaSpecificationExecutor<EmpMaster>{

	// Finding all the employees even if they are deleted
	List<EmpMaster> findAllByOrderByViewingOrderDesc();
	
	// Finding all employees using the deleted column
	List<EmpMaster> findAllByDeletedOrderByViewingOrderDesc(String deleted);
}
