package com.stackroute;



import static org.hamcrest.CoreMatchers.any;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.Controller.AuthenticationServiceController;
import com.stackroute.Dto.AuthenticationServiceDto;
import com.stackroute.JwtUtils.JwtUtil;
import com.stackroute.Model.AuthenticationServiceModel;
import com.stackroute.Repository.AuthenticationServiceRepository;
import com.stackroute.Service.AuthenticationServiceInterfaceImpl;



@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestAuthenticationController {

	private static final byte[] json = null;

	@Mock
	private AuthenticationServiceRepository repository;
	
	@Mock
	AuthenticationServiceInterfaceImpl jwtUserDetailsService;

	@Mock
	private JwtUtil jwtUtil;

	@InjectMocks
	AuthenticationServiceController  authenticationController;

	@InjectMocks
	AuthenticationServiceDto u1;

	@Autowired
	private WebApplicationContext webApplicationContext;
	private MockMvc mockMvc;

	@BeforeEach
	public void setUp() {
		AuthenticationServiceDto u1 = new AuthenticationServiceDto( 6, "klm@gmail.com", "TT", "1212", "ss");

		mockMvc = MockMvcBuilders.standaloneSetup(authenticationController).build();

	}

	
	  @AfterEach public void tearDown() {
	  
	  u1 = null;
	  
	  }
	

	 @Test
	    public void givenProductToSaveReturnSaveProduct() throws Exception {
		 when(jwtUserDetailsService.addUser(u1)).thenReturn(u1);
	        mockMvc.perform(post("/api/v1/authenticationservice/user_save")
	                        .contentType(MediaType.APPLICATION_JSON)
	                        .content(jsonToString(u1)))
	                .andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
	        verify(jwtUserDetailsService, times(1)).addUser(any());
	    }

	
	 
	 private static String jsonToString(final Object o) throws JsonProcessingException {
	        String result;
	        try {
	            ObjectMapper mapper = new ObjectMapper();
	            String jsonContent = mapper.writeValueAsString(o);
	            result = jsonContent;
	            return result;

	        } catch (JsonProcessingException e) {
	            result = "JsonProcessingException";
	        }
	        return result;
	    }
	
//	@Test
//    public void givenUserToSaveReturnSavedUser() throws Exception {
//        String uri = "/api/v1/authenticationservice/user_save";
//       
//        String actualResult = mockMvc
//                .perform(MockMvcRequestBuilders.post(uri).contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(u1)))
//                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
//        Assertions.assertEquals(actualResult, "Customer sucessfully added");
//    }
//
//	 public static String asJsonString(final Object o) {
//	        try {
//	            return new ObjectMapper().writeValueAsString(o);
//	        } catch (Exception e) {
//	            throw new RuntimeException(e);
//	        }
//	    }

}
