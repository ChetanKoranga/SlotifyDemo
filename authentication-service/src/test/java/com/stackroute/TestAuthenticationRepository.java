package com.stackroute;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.stackroute.Dto.AuthenticationServiceDto;
import com.stackroute.Exceptions.UserNotFoundException;
import com.stackroute.Repository.AuthenticationServiceRepository;
import com.stackroute.Service.AuthenticationServiceInterfaceImpl;

@ExtendWith(MockitoExtension.class)
@DataMongoTest
public class TestAuthenticationRepository {

	@Mock
	private AuthenticationServiceRepository repository;

	@Mock
	AuthenticationServiceInterfaceImpl jwtUserDetailsService;

	AuthenticationServiceDto u1;

	@BeforeEach
	public void setUp() {
		AuthenticationServiceDto u1 = new AuthenticationServiceDto(6, "klm@gmail.com", "TT", "1212", "ss");

	}

	@AfterEach
	public void tearDown() {
		u1 = null;

	}

	@Test
	public void givenUserToSaveReturnUser() throws UserNotFoundException {
		jwtUserDetailsService.addUser(u1);
		AuthenticationServiceDto user = repository.findById(u1.getUserId()).get();
		assertNotNull(user);
		assertEquals(u1.getUserId(), user.getUserId());
	}

}
