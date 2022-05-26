//package com.stackroute.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.service.Tag;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//
//public class SwaggerConfig {
//
//    public static final String CUSTOM_TAG = "TAG Service Rest API";
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.learn.swagger.controller"))
//                .paths(PathSelectors.ant("/api/**"))
//                .build()
//                .tags(
//                        new Tag(CUSTOM_TAG, "Custom api endpoints"))
//                .apiInfo(metaData());
//    }
//
//    private ApiInfo metaData() {
//        return new ApiInfoBuilder()
//                .title("Slotify REST API")
//                .description("Spring Boot REST API for Slotify (Slot Booking System)")
//                .version("1.0.0")
//                .license("Apache License Version 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
//                .contact(new Contact("Chetan", "http://swagger.io/", "chetankoranga3@gmail.com"))
//                .build();
//    }
//}
