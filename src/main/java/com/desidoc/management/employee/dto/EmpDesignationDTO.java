package com.desidoc.management.employee.dto;

public class EmpDesignationDTO {
	private Integer id;
	private String designShortName;
    private String designFullName;
    private Integer cadreId; //foreign key for empCadre
    private Integer orderNo;

    // Getters and Setters
    public String getDesignShortName() {
        return designShortName;
    }

    public void setDesignShortName(String designShortName) {
        this.designShortName = designShortName;
    }

    public String getDesignFullName() {
        return designFullName;
    }

    public void setDesignFullName(String designFullName) {
        this.designFullName = designFullName;
    }

    public Integer getCadreId() {
        return cadreId;
    }

    public void setCadreId(Integer cadreId) {
        this.cadreId = cadreId;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

}
