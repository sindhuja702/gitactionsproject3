package com.napier.mlsServices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.napier.mlsServices.dao.UserDAO;
import com.napier.mlsServices.dto.JwtAuthResponseTokenNRole;
import com.napier.mlsServices.dto.SigninRequest;
import com.napier.mlsServices.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

	@Autowired
    private UserDAO userDAO;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
    private JWTService jwtService;


			public JwtAuthResponseTokenNRole signin(SigninRequest signinRequest) {
				authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(), signinRequest.getPassword()));	
				User user= userDAO.findByEmail(signinRequest.getEmail()).orElseThrow(()->new IllegalArgumentException("Invalid email or password") );								
				var jwt= jwtService.generateToken(user);								
				JwtAuthResponseTokenNRole jwtAuthResponseTokenNRole= new JwtAuthResponseTokenNRole();
				jwtAuthResponseTokenNRole.setToken(jwt);
				jwtAuthResponseTokenNRole.setRole(user.getRole());							
				return jwtAuthResponseTokenNRole;
		}

}
