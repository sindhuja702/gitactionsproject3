package com.napier.mlsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.napier.mlsServices.Repository.UserRepo;
import com.napier.mlsServices.entity.User;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
    private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	    long adminCount = userRepo.countByRole("ADMIN");
	    if (adminCount == 0) {
	        User user = new User();
	        user.setLoginName("admin");
	        user.setEmail("admin@gmail.com");
	        user.setRole("ADMIN");
	        user.setPassword(new BCryptPasswordEncoder().encode("admin"));
	        userRepo.save(user);
	    }
	}


}
