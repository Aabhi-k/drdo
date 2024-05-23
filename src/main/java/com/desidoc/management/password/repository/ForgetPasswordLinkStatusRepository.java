package com.desidoc.management.password.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desidoc.management.password.model.ForgetPasswordLinkStatus;

public interface ForgetPasswordLinkStatusRepository extends JpaRepository<ForgetPasswordLinkStatus, Integer> {

}
