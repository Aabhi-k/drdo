package com.desidoc.management.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignAndCadre;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignationFullNameProjection;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignationShortNameProjection;

@Repository
public interface EmpDesignationRepository
		extends JpaRepository<EmpDesignation, Integer>, JpaSpecificationExecutor<EmpDesignation> {
	 @Query("SELECT ed.designShortName as designShortName, ed.designFullName as designFullName, ec.cadreShortName as cadreShortName " +
	           "FROM EmpDesignation ed JOIN ed.cadreId ec ORDER BY ed.orderNo DESC")
	    List<EmpDesignAndCadre> findAllProjectedBy();

	List<EmpDesignation> findAllByOrderByOrderNoDesc();

	List<EmpDesignationShortNameProjection> findByDesignShortNameIsNotNull();

	List<EmpDesignationFullNameProjection> findByDesignFullNameIsNotNull();
	
}
