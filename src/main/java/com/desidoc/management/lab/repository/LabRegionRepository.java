package com.desidoc.management.lab.repository;

import com.desidoc.management.lab.model.LabRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabRegionRepository extends JpaRepository<LabRegion, Integer> {

}
