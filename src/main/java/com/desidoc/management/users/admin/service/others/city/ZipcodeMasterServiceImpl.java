package com.desidoc.management.users.admin.service.others.city;

import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.others.city.ZipcodeMaster;
import com.desidoc.management.others.city.ZipcodeMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ZipcodeMasterServiceImpl implements ZipcodeMasterService {

    @Autowired
    ZipcodeMasterRepository repository;

    @Override
    public ZipcodeMaster findZipcodeById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Zipcode Not found"));
    }


}
