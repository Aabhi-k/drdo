package com.desidoc.management.employee.projections.empmaster;

public interface EmpMasterProjection {
	Integer getId();
	String getEmpFirstName();
	String getEmpLastName();
	String getEmpTitle();
	String getOfficeRoomNo();
	String getAddlDesign();
	
	String getLabFullName();
	String getDesignShortName();
}
