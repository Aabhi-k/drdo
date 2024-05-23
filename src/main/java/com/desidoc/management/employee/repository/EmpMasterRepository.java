package com.desidoc.management.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desidoc.management.employee.model.EmpMaster;
@Repository
public interface EmpMasterRepository extends JpaRepository<EmpMaster, Integer>{

}
