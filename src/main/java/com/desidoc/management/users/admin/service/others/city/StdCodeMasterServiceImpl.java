package com.desidoc.management.users.admin.service.others.city;

import com.desidoc.management.exception.EntityNotFoundException;
import com.desidoc.management.others.city.StdCodeMaster;
import com.desidoc.management.others.city.StdCodeMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StdCodeMasterServiceImpl implements StdCodeMasterService {

    @Autowired
    private StdCodeMasterRepository repository;

    @Override
    public StdCodeMaster findStdCodeById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Std code not found"));

    }

}
