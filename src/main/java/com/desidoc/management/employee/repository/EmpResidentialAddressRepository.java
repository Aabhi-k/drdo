package com.desidoc.management.employee.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desidoc.management.employee.model.EmpResidentialAddress;
import com.desidoc.management.employee.projections.empresidentialaddress.EmpResidentialAddressProjection;
@Repository
public interface EmpResidentialAddressRepository extends JpaRepository<EmpResidentialAddress, Integer>{

		
	@Query("SELECT emp.empFirstName as empFirstName, " +
	           "emp.empLastName as empLastName, " +
	           "address.addressLine1 as addressLine1, " +
	           "address.addressLine2 as addressLine2, " +
	           "address.addressLine3 as addressLine3, " +
	           "zip.zipcode as zipcode, " +
	           "city.cityFullName as cityFullName " +
	           "FROM EmpResidentialAddress address " +
	           "JOIN address.empId emp " +
	           "JOIN address.zipcodeId zip " +
	           "JOIN address.cityId city")
	Page<EmpResidentialAddressProjection> findAllEmpAddressProjections(Pageable page);
	
}
