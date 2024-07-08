package com.desidoc.management.users.admin.service.lab;

import com.desidoc.management.lab.dto.*;
import com.desidoc.management.lab.projections.labDetails.LabDetailsProjection;

public interface LabDetailsService {

    LabDetailsProjection findLabDetailsById(Integer labId);

    String createLabDetails(LabMasterDTO labMasterDTO, LabAddressDTO labAddressDTO, LabEpabxDTO labEpabxDTO, LabFaxMasterDTO labFaxMasterDTO, LabTelephoneMasterDTO labTelephoneMasterDTO);
}
