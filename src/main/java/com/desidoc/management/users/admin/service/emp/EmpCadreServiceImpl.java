package com.desidoc.management.users.admin.service.emp;

import com.desidoc.management.employee.model.EmpCadre;
import com.desidoc.management.employee.repository.EmpCadreRepository;
import com.desidoc.management.exception.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpCadreServiceImpl implements EmpCadreService {

    @Autowired
    EmpCadreRepository repository;

    @Override
    public EmpCadre findEmpCadreById(Integer cadreId) {

        return repository.findById(cadreId)
                .orElseThrow(() -> new EntityNotFoundException("Cadre Id not found"));
    }

}
