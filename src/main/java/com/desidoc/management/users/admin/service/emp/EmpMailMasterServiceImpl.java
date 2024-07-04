package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.model.EmpMailMaster;
import com.desidoc.management.employee.repository.EmpMailMasterRepository;
import com.desidoc.management.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpMailMasterServiceImpl implements EmpMailMasterService {

    @Autowired
    EmpMailMasterRepository repository;

    @Override
    public EmpMailMaster findEmpMailById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Employee Mail not found"));
    }


}
