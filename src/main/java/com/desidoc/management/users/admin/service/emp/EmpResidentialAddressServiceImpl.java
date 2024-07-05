package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.dto.EmpResidentialAddressDTO;
import com.desidoc.management.employee.model.EmpResidentialAddress;
import com.desidoc.management.employee.projections.empresidentialaddress.EmpResidentialAddressProjection;
import com.desidoc.management.employee.repository.EmpResidentialAddressRepository;
import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.users.admin.service.others.city.CityMasterService;
import com.desidoc.management.users.admin.service.others.city.ZipcodeMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EmpResidentialAddressServiceImpl implements EmpResidentialAddressService {
    @Autowired
    EmpResidentialAddressRepository repository;

    @Autowired
    ZipcodeMasterService zipcodeService;
    @Autowired
    EmpMasterService empMasterService;
    @Autowired
    CityMasterService cityMasterService;

    // ------ Helper Methods ------


    private EmpResidentialAddressProjection convertToProjection(EmpResidentialAddressDTO dto) {
        return new EmpResidentialAddressProjection() {

            @Override
            public String getAddressLine1() {
                return dto.getAddressLine1();
            }

            @Override
            public String getAddressLine2() {
                return dto.getAddressLine2();
            }

            @Override
            public String getAddressLine3() {
                return dto.getAddressLine3();
            }

            @Override
            public String getZipcode() {
                return zipcodeService.findZipcodeById(dto.getZipcodeId()).getZipcode();
            }

            @Override
            public String getCityFullName() {
                return cityMasterService.findCityById(dto.getCityId()).getCityFullName();
            }

        };
    }

    private EmpResidentialAddress convertToEntity(EmpResidentialAddressDTO dto, EmpResidentialAddress address) {
        if (dto.getAddressLine1() != null && !dto.getAddressLine1().equals(address.getAddressLine1())) {
            address.setAddressLine1(dto.getAddressLine1());
        }
        if (dto.getAddressLine2() != null && !dto.getAddressLine2().equals(address.getAddressLine2())) {
            address.setAddressLine2(dto.getAddressLine2());
        }
        if (dto.getAddressLine3() != null && !dto.getAddressLine3().equals(address.getAddressLine3())) {
            address.setAddressLine3(dto.getAddressLine3());
        }
        if (dto.getZipcodeId() != null) {
            if (address.getZipcodeId() == null || !dto.getZipcodeId().equals(address.getZipcodeId().getId())) {
                address.setZipcodeId(zipcodeService.findZipcodeById(dto.getZipcodeId()));
            }
        }
        if (dto.getEmpId() != null) {
            if (address.getEmpId() == null || !dto.getEmpId().equals(address.getEmpId().getId())) {
                address.setEmpId(empMasterService.findEmpMasterById(dto.getEmpId()));
            }
        }
        if (dto.getCityId() != null) {
            if (address.getCityId() == null || !dto.getCityId().equals(address.getCityId().getId())) {
                address.setCityId(cityMasterService.findCityById(dto.getCityId()));
            }
        }

        address.setLastUpdated(LocalDateTime.now());

        return address;
    }

    private EmpResidentialAddressDTO convertToDTO(EmpResidentialAddress address) {
        EmpResidentialAddressDTO dto = new EmpResidentialAddressDTO();
        dto.setId(address.getId());
        dto.setAddressLine1(address.getAddressLine1());
        dto.setAddressLine2(address.getAddressLine2());
        dto.setAddressLine3(address.getAddressLine3());
        dto.setZipcodeId(address.getZipcodeId().getId());
        dto.setEmpId(address.getEmpId().getId());
        dto.setCityId(address.getCityId().getId());
        dto.setLastUpdated(address.getLastUpdated());

        return dto;
    }

    @Override
    public EmpResidentialAddress getEmpResidentialAddressById(Integer id) {
        repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee address not found"));
        return null;
    }


    @Override
    public String createEmpAddress(EmpResidentialAddressDTO empResDTO) {
        EmpResidentialAddress address = new EmpResidentialAddress();
        repository.save(this.convertToEntity(empResDTO, address));
        return "emp created";
    }

    @Override
    public EmpResidentialAddressProjection findEmpAddressById(Integer empId) {
        return convertToProjection(convertToDTO(repository.findByEmpId_Id(empId)));
    }

    @Override
    public EmpResidentialAddressDTO findEmpAddressDTOById(Integer empId) {
        return convertToDTO(repository.findByEmpId_Id(empId));
    }

    @Override
    public EmpResidentialAddressDTO getEmpResidentialAddressDTOById(Integer id) {
        return convertToDTO(repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee address not found")));
    }

    @Override
    public String updateEmpAddress(Integer empId, EmpResidentialAddressDTO empResDTO) {
        EmpResidentialAddress address = repository.findByEmpId_Id(empId);
        if (address != null) {
            repository.save(this.convertToEntity(empResDTO, address));
            return "Updated Successfully!";
        } else {
            return "Employee Address not found!";
        }
    }


}
