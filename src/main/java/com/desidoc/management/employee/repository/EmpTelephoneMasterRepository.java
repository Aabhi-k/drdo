package com.desidoc.management.employee.repository;

import com.desidoc.management.employee.model.EmpTelephoneMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpTelephoneMasterRepository extends JpaRepository<EmpTelephoneMaster, Integer> {
    List<EmpTelephoneMaster> findByEmpId_Id(Integer empId);
}
