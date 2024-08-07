package com.desidoc.management.lab.projections.labDetails;

public interface LabDetailsProjection {

    Integer getLabId();
    String getLabAuthName();
    String getLabShortName();
    String getLabFullName();
    String getLabCategoryShortName();
    String getLabCategoryFullName();
    String getLabClusterShortName();
    String getLabClusterFullName();
    String getLabCityFullName();
    String getOtherGroup();
    String getLabAddressLine1();
    String getLabAddressLine2();
    String getLabAddressLine3();
    String getCityFullName();
    String getLabZipcode();

}
