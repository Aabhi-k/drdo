package com.desidoc.management.users.admin.service.lab;

import com.desidoc.management.lab.dto.LabEpabxDTO;
import com.desidoc.management.lab.model.LabEpabxMaster;
import com.desidoc.management.lab.repository.LabEpabxMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class LabEpabxServiceImpl implements LabEpabxService{

    @Autowired
    LabEpabxMasterRepository repository;
    @Autowired
    LabMasterService labMasterService;

    private LabEpabxMaster convertToEntity(LabEpabxDTO dto, LabEpabxMaster entity) {
        if (dto.getLabId() != null) {
            if (entity.getLabId() == null || !dto.getLabId().equals(entity.getLabId().getId())) {
                entity.setLabId(labMasterService.findLabMasterById(dto.getLabId()));
            }
        }
        if (dto.getEpabx() != null && !dto.getEpabx().equals(entity.getEpabx())) {
            entity.setEpabx(dto.getEpabx());
        }
        if(dto.getDidNo() != null && !dto.getDidNo().equals(entity.getDidNo())) {
            entity.setDidNo(dto.getDidNo());
        }
        entity.setLastUpdated(LocalDateTime.now());

        return entity;
    }

    @Override
    public String createLabEpabx(LabEpabxDTO labEpabxDTO) {
        try {
            repository.save(convertToEntity(labEpabxDTO, new LabEpabxMaster()));
            return "Lab Epabx created successfully";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Lab Epabx creation failed";
        }
    }
}
