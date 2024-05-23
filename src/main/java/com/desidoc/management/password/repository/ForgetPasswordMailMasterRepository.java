package com.desidoc.management.password.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desidoc.management.password.model.ForgetPasswordMailMaster;

public interface ForgetPasswordMailMasterRepository extends JpaRepository<ForgetPasswordMailMaster, Integer> {

}
