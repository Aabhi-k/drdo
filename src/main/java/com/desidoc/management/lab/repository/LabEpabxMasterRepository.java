package com.desidoc.management.lab.repository;

import com.desidoc.management.lab.model.LabEpabxMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabEpabxMasterRepository extends JpaRepository<LabEpabxMaster, Integer> {

}
