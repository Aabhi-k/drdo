package com.desidoc.management.login.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desidoc.management.login.model.UserAssignedRole;

@Repository
public interface UserAssignedRoleRepository extends JpaRepository<UserAssignedRole, Integer>{
	List<UserAssignedRole> findByLogin_Id(Integer login);
}
