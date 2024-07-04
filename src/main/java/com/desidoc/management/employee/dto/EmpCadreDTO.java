package com.desidoc.management.employee.dto;

public class EmpCadreDTO {
    private Integer cadreId;
    private String cadreShortName;
    private String cadreFullName;

    // Getters and Setters
    public Integer getCadreId() {
        return cadreId;
    }

    public void setCadreId(Integer cadreId) {
        this.cadreId = cadreId;
    }

    public String getCadreShortName() {
        return cadreShortName;
    }

    public void setCadreShortName(String cadreShortName) {
        this.cadreShortName = cadreShortName;
    }

    public String getCadreFullName() {
        return cadreFullName;
    }

    public void setCadreFullName(String cadreFullName) {
        this.cadreFullName = cadreFullName;
    }


}
