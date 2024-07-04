package com.desidoc.management.lab.repository;

import com.desidoc.management.lab.model.LabMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabMasterRepository extends JpaRepository<LabMaster, Integer>, JpaSpecificationExecutor<LabMaster> {

    List<LabMaster> findAllByDeleted(String deleted);


}
