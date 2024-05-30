package com.desidoc.management.users.admin.service.emp;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desidoc.management.employee.dto.EmpResidentialAddressDTO;
import com.desidoc.management.employee.model.EmpResidentialAddress;
import com.desidoc.management.employee.projections.empresidentialaddress.EmpResidentialAddressProjection;
import com.desidoc.management.employee.repository.EmpResidentialAddressRepository;
import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.users.admin.service.others.city.CityMasterService;
import com.desidoc.management.users.admin.service.others.city.ZipcodeMasterService;

@Service
public class EmpResidentialAddressServiceImpl implements EmpResidentialAddressService{
	@Autowired
	EmpResidentialAddressRepository repository;
	
	@Autowired
	ZipcodeMasterService zipcodeService;
	@Autowired
	EmpMasterService empMasterService;
	@Autowired
	CityMasterService cityMasterService;
	
	
	
	// ------ Helper Methods ------
	
	private EmpResidentialAddress convertToEntity(EmpResidentialAddressDTO dto, EmpResidentialAddress address) {
		if(dto.getAddressLine1() != null && !dto.getAddressLine1().equals(address.getAddressLine1())) {
			address.setAddressLine1(dto.getAddressLine1());
		}
		if(dto.getAddressLine2() != null && !dto.getAddressLine2().equals(address.getAddressLine2())) {
			address.setAddressLine2(dto.getAddressLine2());
		}
		if(dto.getAddressLine3() != null && !dto.getAddressLine3().equals(address.getAddressLine3())) {
			address.setAddressLine3(dto.getAddressLine3());
		}
		if(dto.getZipcodeId() != null) {
			if(address.getZipcodeId() == null || !dto.getZipcodeId().equals(address.getZipcodeId().getId())) {
				address.setZipcodeId(zipcodeService.findZipcodeById(dto.getZipcodeId()));
			}
		}
		if(dto.getEmpId() != null) {
			if(address.getEmpId() == null || !dto.getEmpId().equals(address.getEmpId().getId())) {
				address.setEmpId(empMasterService.findEmpMasterById(dto.getEmpId()));
			}
		}
		if(dto.getCityId() != null) {
			if(address.getCityId() == null || !dto.getCityId().equals(address.getCityId().getId())) {
				address.setCityId(cityMasterService.findCityById(dto.getCityId()));
			}
		}
		if(dto.getLastUpdated() != null && dto.getLastUpdated().equals(dto.getLastUpdated())) {
			address.setLastUpdated(LocalDateTime.now());
		}
		
		return address;
	}
	
	private EmpResidentialAddressDTO convertToDTO(EmpResidentialAddress address) {
		EmpResidentialAddressDTO dto = new EmpResidentialAddressDTO();
		dto.setId(address.getId());
		dto.setAddressLine1(address.getAddressLine1());
		dto.setAddressLine2(address.getAddressLine2());
		dto.setAddressLine3(address.getAddressLine3());
		dto.setZipcodeId(address.getZipcodeId().getId());
		dto.setEmpId(address.getEmpId().getId());
		dto.setCityId(address.getCityId().getId());
		dto.setLastUpdated(address.getLastUpdated());
		
		
		return dto;
	}

	@Override
	public EmpResidentialAddress getEmpResidentialAddressById(Integer id)  {
		repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee address not found"));
		return null;
	}

	@Override
	public List<EmpResidentialAddressDTO> findAllEmpAddress() {
		return null;
	}

	@Override
	public List<EmpResidentialAddressProjection> findAllEmpAddressProjections() {
		return repository.findAllEmpAddressProjections();
	}

}
