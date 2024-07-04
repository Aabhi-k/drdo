package com.desidoc.management.employee.repository;

import com.desidoc.management.employee.model.EmpMailMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpMailMasterRepository extends JpaRepository<EmpMailMaster, Integer> {

}
