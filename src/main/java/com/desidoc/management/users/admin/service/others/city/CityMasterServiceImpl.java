package com.desidoc.management.users.admin.service.others.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.others.city.CityMaster;
import com.desidoc.management.others.city.CityMasterRepository;
import com.desidoc.management.others.projection.DropDownProjection;
import com.desidoc.management.others.specification.CityMasterSpecification;

@Service
public class CityMasterServiceImpl implements CityMasterService{

	@Autowired
	CityMasterRepository repository;
	
	private DropDownProjection convertToDropDown(CityMaster dto) {
		return new DropDownProjection() {

			@Override
			public Integer getId() {
				
				return dto.getId();
			}

			@Override
			public String getName() {
				return dto.getCityFullName();
			}
			
		};
		
	}
	@Override
	public CityMaster findCityById(Integer id) {
		return repository.findById(id).orElseThrow(()-> new EntityNotFoundException("City not found"));
	}

	@Override
	public Page<DropDownProjection> searchCityDropDown(String query, Pageable pageable) {
		Specification<CityMaster> sp = CityMasterSpecification.searchCityMaster(query);
		return repository.findAll(sp,pageable).map(this::convertToDropDown);
	}

}
