package com.desidoc.management.lab.repository;

import com.desidoc.management.lab.model.LabAddressMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabAddressMasterRepository extends JpaRepository<LabAddressMaster, Integer> {

    LabAddressMaster findByLabId_Id(Integer labId);

}
