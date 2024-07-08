package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.dto.EmpMailMasterDTO;
import com.desidoc.management.employee.model.EmpMailMaster;
import com.desidoc.management.employee.projections.empMail.EmpMailProjection;
import com.desidoc.management.employee.repository.EmpMailMasterRepository;
import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.users.admin.service.others.mail.MailCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpMailMasterServiceImpl implements EmpMailMasterService {

    @Autowired
    EmpMailMasterRepository repository;

    @Autowired
    EmpMasterService empMasterService;

    @Autowired
    MailCategoryService mailCategoryService;

    private EmpMailMasterDTO convertToDTO(EmpMailMaster byEmpIdId) {
        EmpMailMasterDTO dto = new EmpMailMasterDTO();
        dto.setEmpId(byEmpIdId.getEmpId().getId());
        dto.setEmail(byEmpIdId.getEmail());
        dto.setMailCatId(byEmpIdId.getMailCatId().getId());
        dto.setLastUpdated(byEmpIdId.getLastUpdated());
        return dto;
    }

    private EmpMailMaster convertToEntity(EmpMailMasterDTO dto, EmpMailMaster entity) {
        if (dto.getEmpId() != null) {
            if (entity.getEmpId() == null || !dto.getEmpId().equals(entity.getEmpId().getId())) {
                entity.setEmpId(empMasterService.findEmpMasterById(dto.getEmpId()));
            }
        }
        if (dto.getEmail() != null && !dto.getEmail().equals(entity.getEmail())) {
            entity.setEmail(dto.getEmail());
        }
        if (dto.getMailCatId() != null) {
            if (entity.getMailCatId() == null || !dto.getMailCatId().equals(entity.getMailCatId().getId())) {
                entity.setMailCatId(mailCategoryService.getMailById(dto.getMailCatId()));
            }
        }
        entity.setLastUpdated(LocalDateTime.now());
        return entity;
    }

    private EmpMailProjection convertToProjection(EmpMailMasterDTO dto) {
        return new EmpMailProjection() {
            @Override
            public String getMailCategory() {
                return mailCategoryService.getMailById(dto.getMailCatId()).getMailCatName();
            }

            @Override
            public String getEmail() {
                return dto.getEmail();
            }
        };
    }

    @Override
    public EmpMailMaster findEmpMailById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee Mail not found"));
    }

    @Override
    public List<EmpMailMasterDTO> findEmpMailDTOById(Integer id) {
        return repository.findByEmpId_Id(id).stream().map(this::convertToDTO).toList();
    }

    @Override
    public List<EmpMailProjection> findEmpMailProjectionById(Integer id) {
        return this.findEmpMailDTOById(id).stream().map(this::convertToProjection).toList();
    }

    @Override
    public String createEmpMail(List<EmpMailMasterDTO> empMailMasterDTOList) {
        repository.saveAll(empMailMasterDTOList.stream().map(dto -> convertToEntity(dto, new EmpMailMaster())).toList());
        return "Mail created successfully";
    }

    @Override
    public String updateEmpMail(Integer empId, List<EmpMailMasterDTO> empMailMasterDtoList) {
        return repository.findByEmpId_Id(empId).stream().map(empMailMaster -> {
            empMailMasterDtoList.stream().filter(dto -> dto.getId().equals(empMailMaster.getId())).findFirst().ifPresent(dto -> {
                convertToEntity(dto, empMailMaster);
                repository.save(empMailMaster);
            });
            return "Mail updated successfully";
        }).findFirst().orElse("Mail not found");
    }


}
