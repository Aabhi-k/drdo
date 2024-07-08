package com.desidoc.management.employee.projections.empDetails;

import com.desidoc.management.employee.projections.empMail.EmpMailProjection;
import com.desidoc.management.employee.projections.empTelephone.EmpTelephoneProjection;

import java.util.List;

public interface EmployeeDetailsProjection {
    Integer getEmpId();

    String getEmpTitle();

    String getEmpFirstName();

    String getEmpMiddleName();

    String getEmpLastName();

    String getEmpDesignation();

    String getOfficeRoomNo();

    String getAddlDesign();

    String getAddressLine1();

    String getAddressLine2();

    String getAddressLine3();

    String getCityFullName();

    String getZipcode();

    String getLabFullName();

    List<EmpTelephoneProjection> getTelephone();

    List<EmpMailProjection> getMail();


}
