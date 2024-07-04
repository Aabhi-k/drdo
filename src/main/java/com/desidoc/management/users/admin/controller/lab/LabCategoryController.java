package com.desidoc.management.users.admin.controller.lab;

import com.desidoc.management.users.admin.service.lab.LabCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lab/category")
public class LabCategoryController {
    @Autowired
    private LabCategoryService service;

    // FOR EDITING CATEGORY

}
