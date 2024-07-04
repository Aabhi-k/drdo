package com.desidoc.management.password.repository;

import com.desidoc.management.password.model.ForgetPasswordLinkStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForgetPasswordLinkStatusRepository extends JpaRepository<ForgetPasswordLinkStatus, Integer> {

}
