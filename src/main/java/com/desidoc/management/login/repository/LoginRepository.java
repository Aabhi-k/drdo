package com.desidoc.management.login.repository;

import com.desidoc.management.login.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Optional<Login> findByLabId_Id(Integer labId);

    Boolean existsByLabId_Id(Integer labId);


}
