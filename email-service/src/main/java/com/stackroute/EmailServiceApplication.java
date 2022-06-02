package com.stackroute;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableEurekaClient
public class EmailServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}

}
