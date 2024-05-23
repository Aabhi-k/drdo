package com.desidoc.management.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desidoc.management.employee.model.EmpResidentialAddress;
@Repository
public interface EmpResidentialAddressRepository extends JpaRepository<EmpResidentialAddress, Integer>{

}
