package com.com.napier.mlsServices.TestServices;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.napier.mlsServices.dao.UserDAO;
import com.napier.mlsServices.dto.JwtAuthResponseTokenNRole;
import com.napier.mlsServices.dto.SigninRequest;
import com.napier.mlsServices.entity.User;
import com.napier.mlsServices.service.AuthenticationService;
import com.napier.mlsServices.service.JWTService;

@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

	  @Mock
	    private UserDAO userDAO;

	    @Mock
	    private PasswordEncoder passwordEncoder;

	    @Mock
	    private AuthenticationManager authenticationManager;

	    @Mock
	    private JWTService jwtService;

	    @InjectMocks
	    private AuthenticationService authenticationService;
	    private SigninRequest validSigninRequest;

	    @BeforeEach
	    void setUp() {
	        validSigninRequest = new SigninRequest("test@example.com", "password");
	    }	

	    @Test
	    void testSignin1() {
	        User mockUser = new User();
	        mockUser.setEmail("test@example.com");
	        mockUser.setRole("USER");

	        when(userDAO.findByEmail(validSigninRequest.getEmail())).thenReturn(java.util.Optional.of(mockUser));

	        JwtAuthResponseTokenNRole result = authenticationService.signin(validSigninRequest);

	        assertNotNull(result);
	        assertEquals(mockUser.getRole(), result.getRole());
	        verify(authenticationManager, times(1)).authenticate(any(UsernamePasswordAuthenticationToken.class));
	        verify(userDAO, times(1)).findByEmail(validSigninRequest.getEmail());
	        verify(jwtService, times(1)).generateToken(mockUser);
	    }

}
