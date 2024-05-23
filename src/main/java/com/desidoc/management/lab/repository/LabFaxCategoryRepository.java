package com.desidoc.management.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desidoc.management.lab.model.LabFaxCategory;

@Repository
public interface LabFaxCategoryRepository extends JpaRepository<LabFaxCategory, Integer> {

}
