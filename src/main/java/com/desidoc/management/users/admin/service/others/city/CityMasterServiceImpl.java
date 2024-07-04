package com.desidoc.management.users.admin.service.others.city;

import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.others.city.CityMaster;
import com.desidoc.management.others.city.CityMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityMasterServiceImpl implements CityMasterService {

    @Autowired
    CityMasterRepository repository;

    @Override
    public CityMaster findCityById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("City not found"));
    }

}
