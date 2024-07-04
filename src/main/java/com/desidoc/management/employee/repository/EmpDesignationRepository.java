package com.desidoc.management.employee.repository;

import com.desidoc.management.employee.model.EmpDesignation;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignProjection;
import com.desidoc.management.employee.projections.empdesignation.EmpDesignationShortNameProjection;
import com.desidoc.management.others.projection.DropdownProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpDesignationRepository
        extends JpaRepository<EmpDesignation, Integer>, JpaSpecificationExecutor<EmpDesignation> {
    @Query("SELECT ed.designShortName as designShortName, "
            + "ed.designFullName as designFullName, "
            + "ec.cadreShortName as cadreShortName "
            + "FROM EmpDesignation ed "
            + "JOIN ed.cadreId ec "
            + "ORDER BY ed.orderNo DESC")
    Page<EmpDesignProjection> findAllProjectedBy(Pageable page);

    List<EmpDesignation> findAllByOrderByOrderNoDesc();

    List<EmpDesignationShortNameProjection> findByDesignShortNameIsNotNull();

    @Query("SELECT ed.id as id, "
            + "ed.designFullName as name "
            + "FROM EmpDesignation ed "
            + "ORDER BY ed.orderNo DESC")
    List<DropdownProjection> findAllProjectionDropDown();

}
