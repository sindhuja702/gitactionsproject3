package com.com.napier.mlsServices.TestRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.napier.mlsServices.Repository.UserRepo;
import com.napier.mlsServices.entity.User;

@ExtendWith(MockitoExtension.class)
class UserRepoTest {

	    @Mock
	    private UserRepo userRepo;

	    @Test
	    public void testFindByEmail_ExistingUser() {
	        String existingEmail = "existing@example.com";
	        User user = new User(0, "ExistingUser", existingEmail, existingEmail, "USER");
	        when(userRepo.findByEmail(existingEmail)).thenReturn(Optional.of(user));
	        Optional<User> result = userRepo.findByEmail(existingEmail);
	        assertTrue(result.isPresent());
	        assertEquals(user, result.get());
	    }

	    @Test
	    public void testFindByEmail_NonExistingUser() {
	        String nonExistingEmail = "nonexisting@example.com";
	        when(userRepo.findByEmail(nonExistingEmail)).thenReturn(Optional.empty());
	        Optional<User> result = userRepo.findByEmail(nonExistingEmail);
	        assertFalse(result.isPresent());
	    }

	  
}
