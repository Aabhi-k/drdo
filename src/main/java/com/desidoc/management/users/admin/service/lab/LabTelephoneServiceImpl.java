package com.desidoc.management.users.admin.service.lab;

import com.desidoc.management.lab.dto.LabTelephoneMasterDTO;
import com.desidoc.management.lab.model.LabTelephoneMaster;
import com.desidoc.management.lab.repository.LabTelephoneMasterRepository;
import com.desidoc.management.users.admin.service.others.city.StdCodeMasterService;
import com.desidoc.management.users.admin.service.others.telephone.TelephoneCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LabTelephoneServiceImpl implements LabTelephoneService{

    @Autowired
    LabTelephoneMasterRepository repository;

    @Autowired
    LabMasterService labMasterService;
    @Autowired
    TelephoneCategoryService telephoneCategoryService;
    @Autowired
    StdCodeMasterService stdCodeMasterService;


    private LabTelephoneMaster convertToEntity(LabTelephoneMasterDTO dto, LabTelephoneMaster entity) throws Exception {
        if (dto.getLabId() != null) {
            if (entity.getLabId() == null || !dto.getLabId().equals(entity.getLabId().getId())) {
                entity.setLabId(labMasterService.findLabMasterById(dto.getLabId()));
            }
        }
        if (dto.getTeleCatId() != null) {
            if (entity.getTeleCatId() == null || !dto.getTeleCatId().equals(entity.getTeleCatId().getId())) {
                entity.setTeleCatId(telephoneCategoryService.findTelephoneCategoryById(dto.getTeleCatId()));
            }
        }
        if (dto.getStdCodeId() != null) {
            if (entity.getStdCodeId() == null || !dto.getStdCodeId().equals(entity.getStdCodeId().getId())) {
                entity.setStdCodeId(stdCodeMasterService.findStdCodeById(dto.getStdCodeId()));
            }
        }
        if (dto.getTelephoneNumber() != null && !dto.getTelephoneNumber().equals(entity.getTelephoneNumber())) {
            entity.setTelephoneNumber(dto.getTelephoneNumber());
        }
        entity.setLastUpdated(LocalDateTime.now());

        return entity;
    }


    @Override
    public String createLabTelephone(LabTelephoneMasterDTO labTelephoneMasterDTO) {
        LabTelephoneMaster labTelephoneMaster = new LabTelephoneMaster();
        try {
            repository.save(convertToEntity(labTelephoneMasterDTO, labTelephoneMaster));
            return "Lab Telephone created successfully";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Lab Telephone creation failed";
    }
}
