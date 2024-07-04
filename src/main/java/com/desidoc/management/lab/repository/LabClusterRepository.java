package com.desidoc.management.lab.repository;

import com.desidoc.management.lab.model.LabCluster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LabClusterRepository extends JpaRepository<LabCluster, Integer>, JpaSpecificationExecutor<LabCluster> {

}
