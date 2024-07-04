package com.desidoc.management.login.repository;

import com.desidoc.management.login.model.UserAssignedRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAssignedRoleRepository extends JpaRepository<UserAssignedRole, Integer> {
    List<UserAssignedRole> findByLogin_Id(Integer login);
}
