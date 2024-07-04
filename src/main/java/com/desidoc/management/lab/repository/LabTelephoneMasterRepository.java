package com.desidoc.management.lab.repository;

import com.desidoc.management.lab.model.LabTelephoneMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabTelephoneMasterRepository extends JpaRepository<LabTelephoneMaster, Integer> {

}
