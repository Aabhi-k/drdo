package com.desidoc.management.others.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ZipcodeMasterRepository extends JpaRepository<ZipcodeMaster, Integer>, JpaSpecificationExecutor<ZipcodeMaster> {

}
