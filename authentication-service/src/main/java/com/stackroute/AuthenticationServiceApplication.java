package com.stackroute;

 import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

 import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
 import org.springframework.context.annotation.Bean;
 import springfox.documentation.builders.ApiInfoBuilder;
 import springfox.documentation.builders.RequestHandlerSelectors;
 import springfox.documentation.service.ApiInfo;
 import springfox.documentation.service.Contact;
 import springfox.documentation.spi.DocumentationType;
 import springfox.documentation.spring.web.plugins.Docket;
 import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient

public class AuthenticationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceApplication.class, args);
	}
	
	  @Bean
	  public Docket api() { return new Docket(DocumentationType.SWAGGER_2)
	  .select() //.paths(PathSelectors.ant("/"))
	  .apis(RequestHandlerSelectors.basePackage("com.stackroute.Controller"))
	  .build() .apiInfo(apiDetails()); }
	 
	 public static final String AUTHORIZATION_HEADER = "Authorization";
	
	
	 private ApiInfo apiDetails() { return new ApiInfoBuilder()
	 .title("Authentication API")
	 .description("This is api for Authentication Purposes")
	  .version("0.0.1").contact(new Contact("Parth"," ","mailtoparth21@gmail.com"))
	 .build(); }
	 
	 
	   
		
		/*
		 * private ApiKey apiKey() { return new ApiKey("JWT",
		 * AUTHORIZATION_HEADER,"header"); }
		 * 
		 * private SecurityContext securityContext() { return
		 * SecurityContext.builder().securityReferences(defaultAuth()).build(); }
		 * 
		 * List<SecurityReference> defaultAuth() { AuthorizationScope authorizationScope
		 * = new AuthorizationScope("global", "accessEverything"); AuthorizationScope[]
		 * authorizationScopes = new AuthorizationScope[1]; authorizationScopes[0] =
		 * authorizationScope; return Arrays.asList(new
		 * SecurityReference("JWT",(springfox.documentation.service.AuthorizationScope[]
		 * ) authorizationScopes)); }
		 */
	   
}

