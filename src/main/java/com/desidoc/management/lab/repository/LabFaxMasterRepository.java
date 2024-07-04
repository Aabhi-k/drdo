package com.desidoc.management.lab.repository;

import com.desidoc.management.lab.model.LabFaxMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabFaxMasterRepository extends JpaRepository<LabFaxMaster, Integer> {

}
