package com.desidoc.management.users.admin.service.lab;

import com.desidoc.management.lab.dto.*;
import com.desidoc.management.lab.model.LabAddressMaster;
import com.desidoc.management.lab.model.LabMaster;
import com.desidoc.management.lab.projections.labDetails.LabDetailsProjection;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabDetailsServiceImpl implements LabDetailsService{

    @Autowired
    LabMasterService labMasterService;
    @Autowired
    LabAddressService labAddressService;
    @Autowired
    LabEpabxService labEpabxService;
    @Autowired
    LabFaxService labFaxService;
    @Autowired
    LabTelephoneService labTelephoneService;




    @Override
    public LabDetailsProjection findLabDetailsById(Integer labId) {
        LabMaster lab = labMasterService.findLabMasterById(labId);
        LabAddressMaster labAddress = labAddressService.findLabAddressById(labId);

        return new LabDetailsProjection() {
            @Override
            public Integer getLabId() {
                return lab.getId();
            }

            @Override
            public String getLabAuthName() {
                return lab.getLabAuthName();
            }

            @Override
            public String getLabShortName() {
                return lab.getLabShortName();
            }

            @Override
            public String getLabFullName() {
                return lab.getLabFullName();
            }

            @Override
            public String getLabCategoryShortName() {
                return lab.getLabCatId().getCatShortName();
            }

            @Override
            public String getLabCategoryFullName() {
                return lab.getLabCatId().getCatFullName();
            }

            @Override
            public String getOtherGroup() {
                return lab.getOtherGroup();
            }

            @Override
            public String getLabAddressLine1() {
                return labAddress.getAddressLine1();
            }

            @Override
            public String getLabAddressLine2() {
                return labAddress.getAddressLine2();
            }

            @Override
            public String getLabAddressLine3() {
                return labAddress.getAddressLine3();
            }

            @Override
            public String getLabCityFullName() {
                return labAddress.getCityId().getCityFullName();
            }

            @Override
            public String getLabZipcode() {
                return labAddress.getZipcodeId().getZipcode();
            }
        };

    }

    @Override
    @Transactional
    public String createLabDetails(LabMasterDTO labMasterDTO, LabAddressDTO labAddressDTO, LabEpabxDTO labEpabxDTO, LabFaxMasterDTO labFaxMasterDTO, LabTelephoneMasterDTO labTelephoneMasterDTO) {
        labMasterService.createLabMaster(labMasterDTO);
        return "";
    }
}
