package com.desidoc.management.users.admin.service.emp;

import java.util.List;

import com.desidoc.management.employee.dto.EmpResidentialAddressDTO;
import com.desidoc.management.employee.model.EmpResidentialAddress;
import com.desidoc.management.employee.projections.empresidentialaddress.EmpResidentialAddressProjection;

public interface EmpResidentialAddressService {

	EmpResidentialAddress getEmpResidentialAddressById(Integer id);
	
	List<EmpResidentialAddressDTO> findAllEmpAddress();
	List<EmpResidentialAddressProjection> findAllEmpAddressProjections();
}
