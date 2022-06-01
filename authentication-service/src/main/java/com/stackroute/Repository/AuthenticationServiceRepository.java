package com.stackroute.Repository;

  
 
import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.data.repository.CrudRepository;
 import org.springframework.stereotype.Repository;
 
import com.stackroute.Dto.AuthenticationServiceDto;
  
@Repository 
public interface AuthenticationServiceRepository extends CrudRepository<AuthenticationServiceDto, Integer>{

	AuthenticationServiceDto findByUserName(String UserName);
	
 }
