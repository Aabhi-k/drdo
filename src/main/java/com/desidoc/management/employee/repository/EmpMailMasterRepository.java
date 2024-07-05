package com.desidoc.management.employee.repository;

import com.desidoc.management.employee.model.EmpMailMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpMailMasterRepository extends JpaRepository<EmpMailMaster, Integer> {

    List<EmpMailMaster> findByEmpId_Id(Integer id);
}
