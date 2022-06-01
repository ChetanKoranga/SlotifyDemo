package com.stackroute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })


public class EmailServiceApplication {



	public static void main(String[] args) {
		SpringApplication.run(EmailServiceApplication.class, args);
	}






	}
