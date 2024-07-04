package com.desidoc.management.employee.repository;

import com.desidoc.management.employee.model.EmpRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRoleRepository extends JpaRepository<EmpRole, Integer>,
        JpaSpecificationExecutor<EmpRole> {

}
