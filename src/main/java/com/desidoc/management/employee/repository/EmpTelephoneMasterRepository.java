package com.desidoc.management.employee.repository;

import com.desidoc.management.employee.model.EmpTelephoneMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpTelephoneMasterRepository extends JpaRepository<EmpTelephoneMaster, Integer> {
    EmpTelephoneMaster findByEmpId_Id(Integer empId);
}
