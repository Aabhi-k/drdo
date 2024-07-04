package com.desidoc.management.password.repository;

import com.desidoc.management.password.model.ForgetPasswordMailMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForgetPasswordMailMasterRepository extends JpaRepository<ForgetPasswordMailMaster, Integer> {

}
