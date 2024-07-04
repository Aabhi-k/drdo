package com.desidoc.management.config;

import com.desidoc.management.login.model.Login;
import com.desidoc.management.login.model.UserAssignedRole;
import com.desidoc.management.login.repository.LoginRepository;
import com.desidoc.management.login.repository.UserAssignedRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    LoginRepository loginRepository;

    @Autowired
    UserAssignedRoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Login user = loginRepository.findByLabId_Id(Integer.parseInt(username)).orElseThrow(() -> new UsernameNotFoundException("Username not found"));

        List<UserAssignedRole> role = roleRepository.findByLogin_Id(user.getId());
        List<GrantedAuthority> authorities = role.stream()
                .map(assignedRole -> new SimpleGrantedAuthority(assignedRole.getRoleId().getRoleName()))
                .collect(Collectors.toList());

        return new User(user.getLabId().getId().toString(), user.getPassword(), authorities);


    }

}
