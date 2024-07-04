package com.desidoc.management.login.dto;

public class LoginDTO {
    private Integer labId;
    private String password;

    // Getters and Setters
    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
