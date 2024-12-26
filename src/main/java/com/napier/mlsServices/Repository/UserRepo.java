package com.napier.mlsServices.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.napier.mlsServices.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String email);
	
	
	@Query("SELECT u FROM User u WHERE u.email = :email")
	User findUserByEmail(String email);
   
	User findByRole(String role);

	long countByRole(String admin);
	List<User> findByLoginNameContainingIgnoreCase(String loginName);
	
    	

//	 @Query("SELECT DISTINCT new map(s.username as username) FROM User s")
//	    List<Object> findDistinctUsernames();
//	List<User> findByUsernameContainingIgnoreCase(String partialUsername);
//	Optional<User> findByUsername(String username);
}
