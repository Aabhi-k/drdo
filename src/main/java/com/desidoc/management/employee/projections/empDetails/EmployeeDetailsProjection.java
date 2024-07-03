package com.desidoc.management.employee.projections.empDetails;

public interface EmployeeDetailsProjection {
	Integer getEmpId();
    Integer getEmpTitle();
    String getEmpFirstName();
    String getEmpMiddleName();
    String getEmpLastName();
    String getEmpDesignation();
    String getOfficeRoomNo();
    String getAddressLine1();
    String getAddressLine2();
    String getAddressLine3();
    String getCityFullName();
    String getZipcode();
    String getLabFullName();
//    
//    Integer getTeleCatId();
//    String getTelephoneNumber();
//    Integer getMailCatId();
//    String getEmail();

	
}
