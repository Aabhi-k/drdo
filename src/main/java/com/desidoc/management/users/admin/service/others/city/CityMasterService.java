package com.desidoc.management.users.admin.service.others.city;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.desidoc.management.others.city.CityMaster;
import com.desidoc.management.others.projection.DropDownProjection;

public interface CityMasterService {

	CityMaster findCityById(Integer id);

	Page<DropDownProjection> searchCityDropDown(String query, Pageable pageable);
}
