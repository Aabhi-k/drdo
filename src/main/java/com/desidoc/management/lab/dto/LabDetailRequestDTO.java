package com.desidoc.management.lab.dto;

public class LabDetailRequestDTO {

    private LabMasterDTO labMasterDTO;
    private LabAddressDTO labAddressDTO;
    private LabTelephoneMasterDTO labTelephoneMasterDTO;
    private LabFaxMasterDTO labFaxMasterDTO;
    private LabEpabxDTO labEpabxDTO;

    public LabMasterDTO getLabMasterDTO() {
        return labMasterDTO;
    }

    public void setLabMasterDTO(LabMasterDTO labMasterDTO) {
        this.labMasterDTO = labMasterDTO;
    }

    public LabAddressDTO getLabAddressDTO() {
        return labAddressDTO;
    }

    public void setLabAddressDTO(LabAddressDTO labAddressDTO) {
        this.labAddressDTO = labAddressDTO;
    }

    public LabTelephoneMasterDTO getLabTelephoneMasterDTO() {
        return labTelephoneMasterDTO;
    }

    public void setLabTelephoneMasterDTO(LabTelephoneMasterDTO labTelephoneMasterDTO) {
        this.labTelephoneMasterDTO = labTelephoneMasterDTO;
    }

    public LabFaxMasterDTO getLabFaxMasterDTO() {
        return labFaxMasterDTO;
    }

    public void setLabFaxMasterDTO(LabFaxMasterDTO labFaxMasterDTO) {
        this.labFaxMasterDTO = labFaxMasterDTO;
    }

    public LabEpabxDTO getLabEpabxDTO() {
        return labEpabxDTO;
    }

    public void setLabEpabxDTO(LabEpabxDTO labEpabxDTO) {
        this.labEpabxDTO = labEpabxDTO;
    }
}
