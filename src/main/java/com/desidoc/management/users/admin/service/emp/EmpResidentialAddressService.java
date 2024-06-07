package com.desidoc.management.users.admin.service.emp;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desidoc.management.employee.model.EmpResidentialAddress;
import com.desidoc.management.employee.projections.empresidentialaddress.EmpResidentialAddressProjection;

public interface EmpResidentialAddressService {

	EmpResidentialAddress getEmpResidentialAddressById(Integer id);
	Page<EmpResidentialAddressProjection> findAllEmpAddressProjections(Pageable page);
}
