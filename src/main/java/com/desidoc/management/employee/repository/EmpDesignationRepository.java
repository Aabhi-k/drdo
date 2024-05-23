package com.desidoc.management.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desidoc.management.employee.model.EmpDesignation;
@Repository
public interface EmpDesignationRepository extends JpaRepository<EmpDesignation,Integer>{

}
