package com.desidoc.management.users.admin.service.lab;

import com.desidoc.management.lab.model.LabFaxCategory;
import com.desidoc.management.lab.repository.LabFaxCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LabFaxCategoryServiceImpl implements LabFaxCategoryService{

    @Autowired
    LabFaxCategoryRepository repository;

    @Override
    public LabFaxCategory findLabFaxCategoryById(Integer faxCatId) {
        try{
            Optional<LabFaxCategory> labFaxCategory = repository.findById(faxCatId);
            if(labFaxCategory.isPresent()){
                return labFaxCategory.get();
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
