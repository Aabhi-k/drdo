package com.desidoc.management.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.desidoc.management.lab.model.LabCluster;

@Repository
public interface LabClusterRepository extends JpaRepository<LabCluster, Integer>, JpaSpecificationExecutor<LabCluster> {

}
