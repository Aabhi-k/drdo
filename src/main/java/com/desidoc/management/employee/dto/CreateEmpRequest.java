package com.desidoc.management.employee.dto;

import java.util.List;

public class CreateEmpRequest {
    private EmpMasterDTO empMaster;
    private List<EmpTelephoneMasterDTO> empTelephoneMasterDTOs;
    private List<EmpMailMasterDTO> empMailMasterDTOs;
    private EmpResidentialAddressDTO empResidentialAddressDTO;

    // Getters and Setters

    public EmpMasterDTO getEmpMaster() {
        return empMaster;
    }

    public void setEmpMaster(EmpMasterDTO empMaster) {
        this.empMaster = empMaster;
    }

    public List<EmpTelephoneMasterDTO> getEmpTelephoneMasterDTOs() {
        return empTelephoneMasterDTOs;
    }

    public void setEmpTelephoneMasterDTOs(List<EmpTelephoneMasterDTO> empTelephoneMasterDTOs) {
        this.empTelephoneMasterDTOs = empTelephoneMasterDTOs;
    }

    public List<EmpMailMasterDTO> getEmpMailMasterDTOs() {
        return empMailMasterDTOs;
    }

    public void setEmpMailMasterDTOs(List<EmpMailMasterDTO> empMailMasterDTOs) {
        this.empMailMasterDTOs = empMailMasterDTOs;
    }

    public EmpResidentialAddressDTO getEmpResidentialAddressDTO() {
        return empResidentialAddressDTO;
    }

    public void setEmpResidentialAddressDTO(EmpResidentialAddressDTO empResidentialAddressDTO) {
        this.empResidentialAddressDTO = empResidentialAddressDTO;
    }
}