package com.desidoc.management.employee.repository;

import com.desidoc.management.employee.model.EmpCadre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpCadreRepository extends JpaRepository<EmpCadre, Integer> {

}
