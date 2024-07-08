package com.desidoc.management.users.admin.service.lab;

import com.desidoc.management.lab.dto.LabAddressDTO;
import com.desidoc.management.lab.model.LabAddressMaster;
import com.desidoc.management.lab.repository.LabAddressMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LabAddressServiceImpl implements  LabAddressService{
    @Autowired
    LabAddressMasterRepository repository;


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


    @Override
    public LabAddressMaster findLabAddressById(Integer labId) {
        return repository.findByLabId_Id(labId);
    }
}
