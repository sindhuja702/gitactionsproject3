package com.com.napier.mlsServices.TestControllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.napier.mlsServices.controller.AuthenticationController;
import com.napier.mlsServices.dto.JwtAuthResponseTokenNRole;
import com.napier.mlsServices.dto.SigninRequest;
import com.napier.mlsServices.service.AuthenticationService;

@ExtendWith(MockitoExtension.class)
class AuthenticationControllerTest {

	    @Mock
	    private AuthenticationService authenticationService;

	    @InjectMocks
	    private AuthenticationController authenticationController;

	    @Test
	    void testSignin() {
	        SigninRequest signinRequest = new SigninRequest("username", "password");
	        JwtAuthResponseTokenNRole expectedResponse = new JwtAuthResponseTokenNRole();
	        when(authenticationService.signin(signinRequest)).thenReturn(expectedResponse);
	        ResponseEntity<JwtAuthResponseTokenNRole> responseEntity = authenticationController.signup1(signinRequest);
	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	        assertEquals(expectedResponse, responseEntity.getBody());
	        verify(authenticationService, times(1)).signin(signinRequest);
	    }

}
