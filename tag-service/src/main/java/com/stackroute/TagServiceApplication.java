package com.stackroute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//<<<<<<< HEAD
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
//=======
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@SpringBootApplication
@EnableSwagger2

//>>>>>>> 8ee1526337e0eec12cdbd7a4a65a065355c02116
public class TagServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TagServiceApplication.class, args);
	}

}
