package com.desidoc.management.password.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desidoc.management.password.model.FirstPassChangeStatus;

public interface FirstPassChangeStatusRepository extends JpaRepository<FirstPassChangeStatus, Integer>{

}
