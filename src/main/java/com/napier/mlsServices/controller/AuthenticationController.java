package com.napier.mlsServices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.napier.mlsServices.dto.JwtAuthResponseTokenNRole;
import com.napier.mlsServices.dto.SigninRequest;
import com.napier.mlsServices.entity.User;
import com.napier.mlsServices.service.AuthenticationService;
import com.napier.mlsServices.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class AuthenticationController {
	
    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
	private UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;
    
	 @PostMapping("/register")
	 public User createUser(@RequestBody User user) {
	     user.setRole("USER");
	     user.setPassword(passwordEncoder.encode(user.getPassword()));
	     return userService.save(user);
	 }
    	
    @PostMapping("/signin")
    public ResponseEntity<JwtAuthResponseTokenNRole> signup1(@RequestBody SigninRequest signinRequest ){
    	return ResponseEntity.ok(authenticationService.signin(signinRequest));
    }
     
}
