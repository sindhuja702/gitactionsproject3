package com.napier.mlsServices.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.napier.mlsServices.Repository.UserRepo;
import com.napier.mlsServices.entity.User;

@Component
public class UserDAO {
	@Autowired
    private UserRepo userRepo;	

	public User save(User user) {
		return userRepo.save(user);
	}

	public Optional<User> findByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public List<User> findByPartialLfindByLoginNameStartingWithIgnoreCaseoginName(String loginName) {
		return userRepo.findByLoginNameContainingIgnoreCase(loginName);
	}

}
