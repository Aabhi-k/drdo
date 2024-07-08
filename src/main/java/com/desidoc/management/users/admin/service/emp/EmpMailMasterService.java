package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.dto.EmpMailMasterDTO;
import com.desidoc.management.employee.model.EmpMailMaster;
import com.desidoc.management.employee.projections.empMail.EmpMailProjection;

import java.util.List;

public interface EmpMailMasterService {

    EmpMailMaster findEmpMailById(Integer id);

    List<EmpMailMasterDTO> findEmpMailDTOById(Integer id);

    List<EmpMailProjection> findEmpMailProjectionById(Integer id);

    String createEmpMail(List<EmpMailMasterDTO> empMailMasterDTOList);

    String updateEmpMail(Integer empId, List<EmpMailMasterDTO> empMailMasterDtoList);
}
