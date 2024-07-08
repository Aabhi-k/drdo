package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.dto.EmpMailMasterDTO;
import com.desidoc.management.employee.dto.EmpMasterDTO;
import com.desidoc.management.employee.dto.EmpResidentialAddressDTO;
import com.desidoc.management.employee.dto.EmpTelephoneMasterDTO;
import com.desidoc.management.employee.projections.empDetails.EmployeeDetailsProjection;

import java.util.List;

public interface EmpDetailsService {
    EmployeeDetailsProjection findEmpDetailsById(Integer id);

    String createEmpDetails(EmpMasterDTO empMasterDTO, List<EmpTelephoneMasterDTO> empTelephoneMasterDTOs, List<EmpMailMasterDTO> empMailMasterDTOs, EmpResidentialAddressDTO empResidentialAddressDTO);

    String updateEmpDetails(Integer id, EmpMasterDTO empMasterDTO, List<EmpTelephoneMasterDTO> empTelephoneMasterDTOs, List<EmpMailMasterDTO> empMailMasterDTOs, EmpResidentialAddressDTO empResidentialAddressDTO);


}
