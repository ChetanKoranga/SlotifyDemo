package com.stackroute.configController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/configservice")
public class ConfigController {
	
	 @GetMapping("/testapigateway")
	    public String testapi ( ) {
	    	return "This is just to check if api gateway (CONFIG SERVICE) is redirected to this controller ";
	    			 
	    }

}
