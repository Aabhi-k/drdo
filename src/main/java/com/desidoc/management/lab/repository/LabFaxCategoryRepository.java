package com.desidoc.management.lab.repository;

import com.desidoc.management.lab.model.LabFaxCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabFaxCategoryRepository extends JpaRepository<LabFaxCategory, Integer> {

}
