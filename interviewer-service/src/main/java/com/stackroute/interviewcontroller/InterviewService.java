package com.stackroute.interviewcontroller;

import org.springframework.data.convert.ReadingConverter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/interviewservice")
public class InterviewService {

	 @GetMapping("/testapigateway")
	    public String testapi ( ) {
	    	return "This is just to check if api gateway (INTERVIEW SERVICE) is redirected to this controller ot not,"
	    			+ " in the next iteration this function can be removed ";
	    }
	
}
