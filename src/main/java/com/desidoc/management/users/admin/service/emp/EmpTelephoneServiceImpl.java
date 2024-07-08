package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.dto.EmpTelephoneMasterDTO;
import com.desidoc.management.employee.model.EmpTelephoneMaster;
import com.desidoc.management.employee.projections.empTelephone.EmpTelephoneProjection;
import com.desidoc.management.employee.repository.EmpTelephoneMasterRepository;
import com.desidoc.management.users.admin.service.others.telephone.TelephoneCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpTelephoneServiceImpl implements EmpTelephoneService {

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

    private EmpTelephoneMasterDTO convertToDTO(EmpTelephoneMaster entity) {
        EmpTelephoneMasterDTO dto = new EmpTelephoneMasterDTO();
        dto.setId(entity.getId());
        dto.setTelephoneNumber(entity.getTelephoneNumber());
        dto.setEpabx(entity.getEpabx());
        dto.setEmpId(entity.getEmpId().getId());
        dto.setTeleCatId(entity.getTeleCatId().getId());
        dto.setLastUpdated(entity.getLastUpdated());
        return dto;
    }
    private EmpTelephoneProjection convertToProjection(EmpTelephoneMasterDTO dto) {
        return new EmpTelephoneProjection() {
            @Override
            public String getTelephoneNumber() {
                return dto.getTelephoneNumber();
            }

            @Override
            public String getTelephoneCategory() {
                return telephoneCategoryService.findTelephoneCategoryById(dto.getTeleCatId()).getTeleCatName();
            }
        };
    }


    @Override
    public String createEmpTelephone(List<EmpTelephoneMasterDTO> empTelephoneMasterDTOList) {
        for (EmpTelephoneMasterDTO dto : empTelephoneMasterDTOList) {
            EmpTelephoneMaster empTelephoneMaster = new EmpTelephoneMaster();
            repository.save(convertToEntity(dto, empTelephoneMaster));
        }
        return "Created Successfully!";
    }

    @Override
    public List<EmpTelephoneMasterDTO> findEmpTelephoneDTOById(Integer empId) {
        return repository.findByEmpId_Id(empId).stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<EmpTelephoneProjection> findEmpTelephoneProjectionById(Integer empId) {
        return this.findEmpTelephoneDTOById(empId).stream().map(this::convertToProjection).collect(Collectors.toList());
    }

    @Override
    public String updateEmpTelephone(Integer empId, List<EmpTelephoneMasterDTO> empTelephoneMasterDTOList) {
        List<EmpTelephoneMaster> existingTelephones = repository.findByEmpId_Id(empId);
        for (EmpTelephoneMasterDTO dto : empTelephoneMasterDTOList) {
            EmpTelephoneMaster empTelephoneMaster = existingTelephones.stream()
                    .filter(t -> t.getId().equals(dto.getId()))
                    .findFirst()
                    .orElse(new EmpTelephoneMaster());
            repository.save(convertToEntity(dto, empTelephoneMaster));
        }
        // Optional: Handle deletion of telephones not included in the DTO list
        return "Updated Successfully!";
    }
}
