package com.desidoc.management.password.repository;

import com.desidoc.management.password.model.FirstPassChangeStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FirstPassChangeStatusRepository extends JpaRepository<FirstPassChangeStatus, Integer> {

}
