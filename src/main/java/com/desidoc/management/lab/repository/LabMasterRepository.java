package com.desidoc.management.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desidoc.management.lab.model.LabMaster;

@Repository
public interface LabMasterRepository extends JpaRepository<LabMaster, Integer> {

}