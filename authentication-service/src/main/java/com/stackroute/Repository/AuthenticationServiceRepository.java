package com.stackroute.Repository;

  
 
import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
 
import com.stackroute.Dto.AuthenticationServiceDto;

import java.util.List;

@Repository 
public interface AuthenticationServiceRepository extends CrudRepository<AuthenticationServiceDto, Integer>{

	AuthenticationServiceDto findByUserName(String UserName);

    List<AuthenticationServiceDto> findByEmail(String email);
	
 }
