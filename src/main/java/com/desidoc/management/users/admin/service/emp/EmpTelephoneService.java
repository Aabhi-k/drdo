package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.dto.EmpTelephoneMasterDTO;
import com.desidoc.management.employee.projections.empTelephone.EmpTelephoneProjection;

import java.util.List;

public interface EmpTelephoneService {

    String createEmpTelephone(List<EmpTelephoneMasterDTO> empTelephoneMasterDTO);

    List<EmpTelephoneMasterDTO> findEmpTelephoneDTOById(Integer empId);

    List<EmpTelephoneProjection> findEmpTelephoneProjectionById(Integer empId);

    String updateEmpTelephone(Integer empId, List<EmpTelephoneMasterDTO> empTelephoneMasterDTOList);
}
