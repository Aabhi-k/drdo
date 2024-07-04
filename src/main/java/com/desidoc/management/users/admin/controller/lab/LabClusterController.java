package com.desidoc.management.users.admin.controller.lab;

import com.desidoc.management.users.admin.service.lab.LabClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lab/cluster")
public class LabClusterController {

    @Autowired
    LabClusterService service;

    // FOR EDITING CLUSTER IN FUTURE

}
