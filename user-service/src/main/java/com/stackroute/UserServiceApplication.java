package com.stackroute;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
//>>>>>>> 8ee1526337e0eec12cdbd7a4a65a065355c02116

@SpringBootApplication
@EnableEurekaClient
public class UserServiceApplication {

@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {

		SpringApplication.run(UserServiceApplication.class, args);
	}

}
