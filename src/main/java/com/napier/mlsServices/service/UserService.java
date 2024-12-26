package com.napier.mlsServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.napier.mlsServices.dao.UserDAO;
import com.napier.mlsServices.entity.User;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService {
	
	@Autowired
    private UserDAO userDAO;	
	
	public UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {				
				return userDAO.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
			}
			
		};
	}

	   @Transactional
	    public User updateRoleByEmail(String email, String newRole) {
	        User user = userDAO.findByEmail(email)
	                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

	        user.setRole(newRole);
	        return userDAO.save(user);
	    }

	public User save(User user) {
		return userDAO.save(user);
	}

	public List<User> findByPartialLfindByLoginNameStartingWithIgnoreCaseoginName(String loginName) {
		return userDAO.findByPartialLfindByLoginNameStartingWithIgnoreCaseoginName(loginName);
	}

}
