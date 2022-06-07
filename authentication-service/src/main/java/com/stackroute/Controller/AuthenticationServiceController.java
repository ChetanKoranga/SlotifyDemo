package com.stackroute.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.Dto.AuthenticationServiceDto;
import com.stackroute.Exceptions.UserNotFoundException;
import com.stackroute.JwtService.CustomUserDetailService;
import com.stackroute.JwtUtils.JwtUtil;
import com.stackroute.Model.AuthenticationServiceModel;
import com.stackroute.Repository.AuthenticationServiceRepository;
import com.stackroute.Service.AuthenticationServiceInterface;
import com.stackroute.Service.AuthenticationServiceInterfaceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1/authenticationservice")
public class AuthenticationServiceController extends Exception{

	/*
	 * THE JSON {
    "userId": 2,
    "userName": "a2",
    "password": "p2",
    "userRole": "r2",
    "email": "sosocompleted@gmail.com"
}
	 * http://localhost:8095/swagger-ui.html#/authentication-service-controller
	 */

	@Autowired
	private AuthenticationServiceInterfaceImpl authenticationServiceInterfaceImplobj;
	
	@Autowired
	private AuthenticationManager authenticationManager; 

	@Autowired
	private AuthenticationServiceRepository repository;
	
	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private CustomUserDetailService userDetailsService;

	/*
	 * @Autowired JwtUserDetailsService JwtUserDetailsService;
	 * 
	 * 
	 */	
		
	
	 @GetMapping("/testapigateway")
	    public String testapi ( ) {
	    	return "This is just to check if api gateway (AUTHENTICATION SERVICE) is redirected to this controller";
	    		 }
	 
	 
	 
	@GetMapping(value = "/getall",produces="application/json")				// getting all values -- swagger 
	@ApiOperation(value = "Get all users ", notes = "This api will give all the users, if present")
	public ResponseEntity<Object> findingAll() throws UserNotFoundException {
		return authenticationServiceInterfaceImplobj.gettingAll();
	}

	
	@GetMapping(value = "/getuser/{id}",produces="application/json")		// getting user by id -- swagger 
	@ApiOperation(value = "Getting the user by Id", notes = "This api will return theuser by Id, if present ")
	public ResponseEntity<Object> getbyid(@PathVariable ("id") int id) throws UserNotFoundException {
		return authenticationServiceInterfaceImplobj.findByUser(id);
	}
	
	
	@PostMapping(value = "/new",produces="application/json")				// adding new user -- swagger
	@ApiOperation(value = "Saving details of new user ", notes = "This api willsave the new user data")
	public ResponseEntity<?> newUser(@RequestBody AuthenticationServiceModel asmobj) {
		System.out.println("Body data:    "+asmobj.toString());
		return authenticationServiceInterfaceImplobj.NewUser(asmobj);
	}
	
	
	@PutMapping(value="/update/{userId}",produces="application/json")      // updating user by id -- swagger 
	@ApiOperation(value = "Updating user on Id", notes = "This api will update the user data by Id")
	public ResponseEntity<Object>updatingUser( @RequestBody AuthenticationServiceDto asdobj,
			  																	   @PathVariable ("userId") int userId) throws UserNotFoundException {
		return authenticationServiceInterfaceImplobj.UpdatingUser(asdobj, userId );
	}
	 
	
	@RequestMapping(value = "/user_login", method = RequestMethod.POST)
	@ApiOperation(value = "Authenticating the details ofuser ", notes = "This api will authenticate the new user data")
	public String generateToken(@RequestBody AuthenticationServiceModel authRequest) throws UserNotFoundException {
		String userNameEntered = authRequest.getUserName().toString();
		String passwordEntered = authRequest.getPassword().toString();
		AuthenticationServiceDto user = repository.findByUserName(authRequest.getUserName().toString());
	
		if (userNameEntered.equalsIgnoreCase(user.getUserName().toString())
					&& passwordEntered.equalsIgnoreCase(user.getPassword().toString())) {	
		return jwtUtil.generateToken(authRequest.getUserName());
	}		
		 else {
			 throw new  UserNotFoundException("Invalid credentials" );

		 }	
	}
	
	  @RequestMapping(value = "/user_save", method =RequestMethod.POST)
	  
	  @ApiOperation(value = "Saving details of new user ", notes ="This api willsave the new user data")
	  public void saveUser(@RequestBody AuthenticationServiceDto user) throws Exception {
	  
	  repository.save(user);
	  
	  }
	 

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
	
 

}
