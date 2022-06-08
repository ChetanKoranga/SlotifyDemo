package com.stackroute;



import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.stackroute.Dto.AuthenticationServiceDto;
import com.stackroute.JwtUtils.JwtUtil;
import com.stackroute.Repository.AuthenticationServiceRepository;



@AutoConfigureMockMvc
public class TestAuthenticationService extends AuthenticationServiceApplicationTests {
	@Mock
	private AuthenticationServiceRepository repository;

	@Mock
	private JwtUtil jwtUtil;

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void saveUserTest() {
		AuthenticationServiceDto user = new AuthenticationServiceDto();
		user.setEmail("it@gmail.com");
		user.setPassword("1256");
		user.setUserRole("tagteam");
		repository.save(user);
		verify(repository, times(1)).save(any());

	}

	@Test
	public void generateTokenTest() throws Exception {
		String token = jwtUtil.generateToken("it@gmail.com");

		assertNull("Token not generated", token);

	}

}
