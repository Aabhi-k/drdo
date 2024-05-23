package com.desidoc.management.others.telephone;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelephoneCategoryRepository extends JpaRepository<TelephoneCategory,Integer>{

}
