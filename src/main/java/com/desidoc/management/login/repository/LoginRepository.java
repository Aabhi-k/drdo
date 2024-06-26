package com.desidoc.management.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desidoc.management.lab.model.LabMaster;
import com.desidoc.management.login.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	Optional<Login> findByLabId_Id(Integer labId);
	Boolean existsByLabId_Id(Integer labId);
	

}
