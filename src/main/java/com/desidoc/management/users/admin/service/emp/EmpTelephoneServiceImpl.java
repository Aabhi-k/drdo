package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.dto.EmpTelephoneMasterDTO;
import com.desidoc.management.employee.model.EmpTelephoneMaster;
import com.desidoc.management.employee.repository.EmpTelephoneMasterRepository;
import com.desidoc.management.users.admin.service.others.telephone.TelephoneCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmpTelephoneServiceImpl implements EmpTelephoneService{

    @Autowired
    EmpTelephoneMasterRepository repository;

    @Autowired
    EmpMasterService empMasterService;

    @Autowired
    TelephoneCategoryService telephoneCategoryService;


    private EmpTelephoneMaster convertToEntity(EmpTelephoneMasterDTO dto, EmpTelephoneMaster entity) {
        if (dto.getTelephoneNumber() != null && !dto.getTelephoneNumber().equals(entity.getTelephoneNumber())) {
            entity.setTelephoneNumber(dto.getTelephoneNumber());
        }
        if (dto.getEpabx() != null && !dto.getEpabx().equals(entity.getEpabx())) {
            entity.setEpabx(dto.getEpabx());
        }
        if (dto.getEmpId() != null) {
            if (entity.getEmpId() == null || !dto.getEmpId().equals(entity.getEmpId().getId())) {
                entity.setEmpId(empMasterService.findEmpMasterById(dto.getEmpId()));
            }
        }
        if (dto.getTeleCatId() != null) {
            if (entity.getTeleCatId() == null || !dto.getTeleCatId().equals(entity.getTeleCatId().getId())) {
                entity.setTeleCatId(telephoneCategoryService.findTelephoneCategoryById(dto.getTeleCatId()));
            }
        }

        entity.setLastUpdated(LocalDateTime.now());

        return entity;
    }


    @Override
    public String createEmpTelephone(EmpTelephoneMasterDTO empTelephoneMasterDTO) {
        EmpTelephoneMaster empTelephoneMaster = new EmpTelephoneMaster();
        repository.save(convertToEntity(empTelephoneMasterDTO, empTelephoneMaster));
        return "Created Successfully!";
    }
}
