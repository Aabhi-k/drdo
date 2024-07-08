package com.desidoc.management.users.admin.service.lab;

import com.desidoc.management.lab.dto.LabFaxMasterDTO;
import com.desidoc.management.lab.model.LabFaxMaster;
import com.desidoc.management.lab.repository.LabFaxMasterRepository;
import com.desidoc.management.users.admin.service.others.city.StdCodeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LabFaxServiceImpl implements LabFaxService{

    @Autowired
    private LabFaxMasterRepository repository;
    @Autowired
    private LabMasterService labMasterService;
    @Autowired
    private LabFaxCategoryService labFaxCategoryService;
    @Autowired
    private StdCodeMasterService stdCodeMasterService;

    private LabFaxMaster convertToEntity(LabFaxMasterDTO dto, LabFaxMaster entity)  {
        if (dto.getLabId() != null) {
            if (entity.getLabId() == null || !dto.getLabId().equals(entity.getLabId().getId())) {
                entity.setLabId(labMasterService.findLabMasterById(dto.getLabId()));
            }
        }
        if (dto.getFaxNo() != null && !dto.getFaxNo().equals(entity.getFaxNo())) {
            entity.setFaxNo(dto.getFaxNo());
        }
        if(dto.getStdCodeId() != null) {
            if(entity.getStdCodeId() == null || !dto.getStdCodeId().equals(entity.getStdCodeId().getId())) {
                entity.setStdCodeId(stdCodeMasterService.findStdCodeById(dto.getStdCodeId()));
            }
        }
        if (dto.getFaxCatId() != null) {
            if (entity.getFaxCatId() == null || !dto.getFaxCatId().equals(entity.getFaxCatId().getId())) {
                entity.setFaxCatId(labFaxCategoryService.findLabFaxCategoryById(dto.getFaxCatId()));
            }
        }
        entity.setLastUpdated(LocalDateTime.now());

        return entity;
    }

    @Override
    public String createLabFax(LabFaxMasterDTO labFaxMasterDTO) {
        try{
            repository.save(convertToEntity(labFaxMasterDTO, new LabFaxMaster()));
            return "Lab Fax created successfully";
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Lab Fax creation failed";
        }

    }
}
