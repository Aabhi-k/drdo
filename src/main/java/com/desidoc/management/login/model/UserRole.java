package com.desidoc.management.login.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_role")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "role_name", length = 45)
    private String roleName;

    @Column(name = "last_updated")
    private LocalDateTime lastUpdated;

    //	Constructors

    public UserRole() {
    }

    public UserRole(Integer id, String roleName, LocalDateTime lastUpdated) {
        super();
        this.id = id;
        this.roleName = roleName;
        this.lastUpdated = lastUpdated;
    }

    //Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }


}
