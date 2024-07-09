package com.desidoc.management.lab.projections.labmaster;

public interface LabMasterProjection {

    Integer getId();

    String getLabAuthName();

    String getLabShortName();

    String getLabFullName();

    String getCatFullName();

    String getClusterFullName();

    String getCityFullName();

    String getOtherGroup();

}
