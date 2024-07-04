package com.desidoc.management.users.login.controller;

import com.desidoc.management.login.dto.AuthResponseDTO;
import com.desidoc.management.login.dto.LoginDTO;
import com.desidoc.management.users.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private LoginService service;


    @PostMapping("/register")
    ResponseEntity<String> registerUser(@RequestBody LoginDTO loginRequest) {

        return ResponseEntity.ok(service.registerUser(loginRequest));
    }

    @PostMapping("/login")
    public AuthResponseDTO login(@RequestBody LoginDTO loginRequest) {

        return service.loginUser(loginRequest);
    }

}
