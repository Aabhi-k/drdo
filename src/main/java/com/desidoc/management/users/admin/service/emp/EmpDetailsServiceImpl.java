package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.dto.EmpMailMasterDTO;
import com.desidoc.management.employee.dto.EmpMasterDTO;
import com.desidoc.management.employee.dto.EmpResidentialAddressDTO;
import com.desidoc.management.employee.dto.EmpTelephoneMasterDTO;
import com.desidoc.management.employee.model.EmpMaster;
import com.desidoc.management.employee.projections.empDetails.EmployeeDetailsProjection;
import com.desidoc.management.employee.projections.empMail.EmpMailProjection;
import com.desidoc.management.employee.projections.empTelephone.EmpTelephoneProjection;
import com.desidoc.management.employee.projections.empresidentialaddress.EmpResidentialAddressProjection;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpDetailsServiceImpl implements EmpDetailsService {

    @Autowired
    private EmpMasterService empMasterService;
    @Autowired
    private EmpMailMasterService empMailMasterService;
    @Autowired
    private EmpTelephoneService empTelephoneService;
    @Autowired
    private EmpResidentialAddressService empResidentialAddressService;

    public EmployeeDetailsProjection findEmpDetailsById(Integer id) {
        EmpMaster emp = empMasterService.findEmpMasterById(id);
        EmpResidentialAddressProjection address = empResidentialAddressService.findEmpAddressById(id);
        List<EmpTelephoneProjection> telephones = empTelephoneService.findEmpTelephoneProjectionById(id);
        List<EmpMailProjection> mail = empMailMasterService.findEmpMailProjectionById(id);
        return new EmployeeDetailsProjection() {
            @Override
            public Integer getEmpId() {
                return emp.getId();
            }

            @Override
            public String getEmpTitle() {
                return emp.getEmpTitle();
            }

            @Override
            public String getEmpFirstName() {
                return emp.getEmpFirstName();
            }

            @Override
            public String getEmpMiddleName() {
                return emp.getEmpMiddleName();
            }

            @Override
            public String getEmpLastName() {
                return emp.getEmpLastName();
            }

            @Override
            public String getEmpDesignation() {
                return emp.getEmpDesignId().getDesignFullName();
            }

            @Override
            public String getOfficeRoomNo() {
                return emp.getOfficeRoomNo();
            }

            @Override
            public String getAddlDesign() {
                return emp.getAddlDesign();
            }

            @Override
            public String getAddressLine1() {
                return address.getAddressLine1();
            }

            @Override
            public String getAddressLine2() {
                return address.getAddressLine2();
            }

            @Override
            public String getAddressLine3() {
                return address.getAddressLine3();
            }

            @Override
            public String getCityFullName() {
                return address.getCityFullName();
            }

            @Override
            public String getZipcode() {
                return address.getZipcode();
            }

            @Override
            public String getLabFullName() {
                return emp.getLabId().getLabFullName();
            }

            @Override
            public List<EmpTelephoneProjection> getTelephone() {
                return telephones;
            }

            @Override
            public List<EmpMailProjection> getMail() {
                return mail;
            }
        };
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public String createEmpDetails(EmpMasterDTO empMasterDTO, List<EmpTelephoneMasterDTO> empTelephoneMasterDTOs, List<EmpMailMasterDTO> empMailMasterDTOs, EmpResidentialAddressDTO empResidentialAddressDTO) {
        try {
            Integer id = empMasterService.createEmpMaster(empMasterDTO);

            empTelephoneMasterDTOs.forEach(dto -> dto.setEmpId(id));
            empMailMasterDTOs.forEach(dto -> dto.setEmpId(id));
            empResidentialAddressDTO.setEmpId(id);

            empTelephoneService.createEmpTelephone(empTelephoneMasterDTOs);
            empMailMasterService.createEmpMail(empMailMasterDTOs);
            empResidentialAddressService.createEmpAddress(empResidentialAddressDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Created Successfully!";
    }

    @Override
    public String updateEmpDetails(Integer id, EmpMasterDTO empMasterDTO, List<EmpTelephoneMasterDTO> empTelephoneMasterDTOs, List<EmpMailMasterDTO> empMailMasterDTOs, EmpResidentialAddressDTO empResidentialAddressDTO) {
        try {

            empMasterService.updateEmpMaster(empMasterDTO, id);

            empTelephoneMasterDTOs.forEach(dto -> dto.setEmpId(id));
            empMailMasterDTOs.forEach(dto -> dto.setEmpId(id));
            empResidentialAddressDTO.setEmpId(id);

            empTelephoneService.updateEmpTelephone(id, empTelephoneMasterDTOs);
            empMailMasterService.updateEmpMail(id, empMailMasterDTOs);
            empResidentialAddressService.updateEmpAddress(id ,empResidentialAddressDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return "Updated Successfully!";
    }
}
