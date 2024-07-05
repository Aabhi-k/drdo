package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.dto.EmpTelephoneMasterDTO;

import java.util.List;

public interface EmpTelephoneService {

    String createEmpTelephone(List<EmpTelephoneMasterDTO> empTelephoneMasterDTO);

    List<EmpTelephoneMasterDTO> findEmpTelephoneDTOById(Integer empId);

    String updateEmpTelephone(Integer empId, List<EmpTelephoneMasterDTO> empTelephoneMasterDTOList);
}
