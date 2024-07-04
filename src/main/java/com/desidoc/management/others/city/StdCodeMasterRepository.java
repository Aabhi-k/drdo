package com.desidoc.management.others.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StdCodeMasterRepository extends JpaRepository<StdCodeMaster, Integer> {

}
