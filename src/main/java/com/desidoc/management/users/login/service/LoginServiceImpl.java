package com.desidoc.management.users.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.desidoc.management.config.CustomUserDetailsService;
import com.desidoc.management.config.jwt.JwtGenerator;
import com.desidoc.management.login.dto.AuthResponseDTO;
import com.desidoc.management.login.dto.LoginDTO;
import com.desidoc.management.login.model.Login;
import com.desidoc.management.login.model.UserAssignedRole;
import com.desidoc.management.login.model.UserRole;
import com.desidoc.management.login.repository.LoginRepository;
import com.desidoc.management.login.repository.UserAssignedRoleRepository;
import com.desidoc.management.login.repository.UserRoleRepository;
import com.desidoc.management.users.admin.service.lab.LabMasterService;

@Service
public class LoginServiceImpl implements LoginService {

	private LoginRepository repository;
	private LabMasterService labService;
	private AuthenticationManager authenticationManager;
	private PasswordEncoder passwordEncoder;
	private UserRoleRepository roleRepository;
	private UserAssignedRoleRepository assignedRoleRepository;
	private JwtGenerator jwtGenerator;
	private CustomUserDetailsService userDetailsService;

	@Autowired
	public LoginServiceImpl(LoginRepository repository, LabMasterService labService,
			AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
			UserRoleRepository roleRepository, UserAssignedRoleRepository assignedRoleRepository,
			JwtGenerator jwtGenerator, CustomUserDetailsService userDetailsService) {
		super();
		this.repository = repository;
		this.labService = labService;
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.roleRepository = roleRepository;
		this.assignedRoleRepository = assignedRoleRepository;
		this.jwtGenerator = jwtGenerator;
		this.userDetailsService = userDetailsService;
	}

	@Override
	public AuthResponseDTO loginUser(LoginDTO loginDto) {
		Authentication auth = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getLabId(), loginDto.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(auth);

		final UserDetails userDetails = userDetailsService.loadUserByUsername(loginDto.getLabId().toString());
		final String token = jwtGenerator.generateToken(userDetails);

		Login user = repository.findByLabId_Id(loginDto.getLabId()).get();
	    String username = user.getUsername();


		return new AuthResponseDTO(token, username);
	}

	@Override
	public String registerUser(LoginDTO loginDto) {
		if (repository.existsByLabId_Id(loginDto.getLabId())) {
			return "User Already Exist";
		}
		Login user = new Login();
		user.setLabId(labService.findLabMasterById(loginDto.getLabId()));
		user.setPassword(passwordEncoder.encode(loginDto.getPassword()));
		user.setActive("0");
		UserRole role = roleRepository.findByRoleName("ADMIN").get(); 

		UserAssignedRole assignedRole = new UserAssignedRole();

		repository.save(user);
		
		assignedRole.setUserId(user);
		assignedRole.setRoleId(role);

		assignedRoleRepository.save(assignedRole);

		return "user created";
	}

}
