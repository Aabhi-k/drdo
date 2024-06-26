package com.desidoc.management.users.admin.controller.others.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desidoc.management.users.admin.service.others.city.CityMasterService;

@RestController
@RequestMapping("/api/city")		
public class CityMasterController {
	@Autowired
	CityMasterService service;
	
	// FOR CITY IN FUTURE
}
