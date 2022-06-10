package com.stackroute.interviewerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
public class InterviewerServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(InterviewerServiceApplication.class, args);
	}

}
