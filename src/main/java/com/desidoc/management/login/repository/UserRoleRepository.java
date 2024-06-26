package com.desidoc.management.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.desidoc.management.login.model.UserRole;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Integer>{
	Optional<UserRole> findByRoleName(String roleName);

}
