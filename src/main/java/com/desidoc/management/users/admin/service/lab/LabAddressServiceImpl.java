package com.desidoc.management.users.admin.service.lab;

import com.desidoc.management.lab.dto.LabAddressDTO;
import com.desidoc.management.lab.model.LabAddressMaster;
import com.desidoc.management.lab.repository.LabAddressMasterRepository;
import com.desidoc.management.users.admin.service.others.city.CityMasterService;
import com.desidoc.management.users.admin.service.others.city.ZipcodeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabAddressServiceImpl implements  LabAddressService{
    @Autowired
    LabAddressMasterRepository repository;
    @Autowired
    LabMasterService labMasterService;
    @Autowired
    CityMasterService cityMasterService;
    @Autowired
    ZipcodeMasterService zipcodeMasterService;


    private LabAddressDTO convertToDTO(LabAddressMaster entity){
        LabAddressDTO dto = new LabAddressDTO();
        dto.setLabId(entity.getId());
        dto.setAddressLine1(entity.getAddressLine1());
        dto.setAddressLine2(entity.getAddressLine2());
        dto.setAddressLine3(entity.getAddressLine3());
        dto.setCityId(entity.getCityId().getId());
        dto.setZipcodeId(entity.getZipcodeId().getId());
        dto.setLastUpdated(entity.getLastUpdated());

        return dto;
    }

    private LabAddressMaster convertToEntity(LabAddressDTO dto, LabAddressMaster entity) {
        if (dto.getLabId() != null) {
            if (entity.getLabId() == null || !dto.getLabId().equals(entity.getLabId())) {
                entity.setLabId(labMasterService.findLabMasterById(dto.getLabId()));
            }
        }
        if (dto.getAddressLine1() != null && !dto.getAddressLine1().equals(entity.getAddressLine1())) {
            entity.setAddressLine1(dto.getAddressLine1());
        }
        if (dto.getAddressLine2() != null && !dto.getAddressLine2().equals(entity.getAddressLine2())) {
            entity.setAddressLine2(dto.getAddressLine2());
        }
        if (dto.getAddressLine3() != null && !dto.getAddressLine3().equals(entity.getAddressLine3())) {
            entity.setAddressLine3(dto.getAddressLine3());
        }
        if (dto.getCityId() != null) {
            if (entity.getCityId() == null || !dto.getCityId().equals(entity.getCityId().getId())) {
                entity.setCityId(cityMasterService.findCityById(dto.getCityId()));
            }
        }
        if (dto.getZipcodeId() != null) {
            if (entity.getZipcodeId() == null || !dto.getZipcodeId().equals(entity.getZipcodeId().getId())) {
                entity.setZipcodeId(zipcodeMasterService.findZipcodeById(dto.getZipcodeId() ));
            }
        }
        entity.setLastUpdated(dto.getLastUpdated());

        return entity;
    }

    @Override
    public LabAddressMaster findLabAddressById(Integer labId) {
        return repository.findByLabId_Id(labId);
    }

    @Override
    public String createLabAddress(LabAddressDTO labAddressDTO) {
        LabAddressMaster labAddressMaster = new LabAddressMaster();
        try {
            repository.save(convertToEntity(labAddressDTO, labAddressMaster));
            return "Lab Address created successfully";
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Lab Address creation failed";
    }
}
