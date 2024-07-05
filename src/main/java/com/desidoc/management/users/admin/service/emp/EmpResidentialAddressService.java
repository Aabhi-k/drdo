package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.dto.EmpResidentialAddressDTO;
import com.desidoc.management.employee.model.EmpResidentialAddress;
import com.desidoc.management.employee.projections.empresidentialaddress.EmpResidentialAddressProjection;

public interface EmpResidentialAddressService {

    EmpResidentialAddress getEmpResidentialAddressById(Integer id);

    String createEmpAddress(EmpResidentialAddressDTO empResDTO);

    EmpResidentialAddressProjection findEmpAddressById(Integer empId);


    EmpResidentialAddressDTO findEmpAddressDTOById(Integer empId);

    EmpResidentialAddressDTO getEmpResidentialAddressDTOById(Integer id);

    String updateEmpAddress(Integer empId, EmpResidentialAddressDTO empResDTO);
}
