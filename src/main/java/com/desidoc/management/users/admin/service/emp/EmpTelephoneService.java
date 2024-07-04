package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.dto.EmpTelephoneMasterDTO;

public interface EmpTelephoneService {

    String createEmpTelephone(EmpTelephoneMasterDTO empTelephoneMasterDTO);

    EmpTelephoneMasterDTO findEmpTelephoneDTOById(Integer empId);
}
