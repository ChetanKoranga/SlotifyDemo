package com.stackroute.emailcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/emailservice")
public class EmailController {
	
	 @GetMapping("/testapigateway")
	    public String testapi ( ) {
	    	return "This is just to check if api gateway (EMAIL SERVICE) is redirected to this controller ot not,"
	    			+ " in the next iteration this function can be removed ";
	    }

}
