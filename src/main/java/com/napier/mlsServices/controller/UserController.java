package com.napier.mlsServices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.napier.mlsServices.entity.User;
import com.napier.mlsServices.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/mls/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class UserController {	
	 @Autowired
	 private UserService userService;
	 @Autowired
	 private PasswordEncoder passwordEncoder;
	 
	 @GetMapping("/hi")
	 public String HiUser() {
		 return "Hi User";
	 }

	 @PutMapping("/updateRole")
	 public User updateRoleByEmail(@RequestParam String email, @RequestParam String newRole) {
	     return userService.updateRoleByEmail(email, newRole);
	 }

	 @GetMapping("/search")
	 public List<User> searchUsersByPartialLoginName(@RequestParam String username) {
	     return userService.findByPartialLfindByLoginNameStartingWithIgnoreCaseoginName(username);
	 }
	 
}
