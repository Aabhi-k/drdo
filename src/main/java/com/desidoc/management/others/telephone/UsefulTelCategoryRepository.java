package com.desidoc.management.others.telephone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsefulTelCategoryRepository extends JpaRepository<UsefulTelCategory, Integer> {

}
