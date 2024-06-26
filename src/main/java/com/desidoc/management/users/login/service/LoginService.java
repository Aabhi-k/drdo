package com.desidoc.management.users.login.service;

import com.desidoc.management.login.dto.AuthResponseDTO;
import com.desidoc.management.login.dto.LoginDTO;

public interface LoginService {
	AuthResponseDTO loginUser(LoginDTO loginDto);
	String registerUser(LoginDTO loginDto);
}
