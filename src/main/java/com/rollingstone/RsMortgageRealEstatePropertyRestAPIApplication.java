package com.rollingstone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
 * This is the primary Spring Boot application class. It configures Spring Boot, JPA, Swagger and 
 * other dependent Spring modules.
 */ 

@SuppressWarnings("deprecation")
@EnableAutoConfiguration  // Sprint Boot Automatic Configuration
@ComponentScan(basePackages = "com.rollingstone")
@EnableJpaRepositories("com.rollingstone.dao.jpa") // To segregate MongoDB and JPA repositories. Otherwise not needed.
@EnableSwagger2
@EnableDiscoveryClient
@EnableFeignClients
public class RsMortgageRealEstatePropertyRestAPIApplication extends SpringBootServletInitializer {

    private static final Class<RsMortgageRealEstatePropertyRestAPIApplication> applicationClass = RsMortgageRealEstatePropertyRestAPIApplication.class;
    private static final Logger log = LoggerFactory.getLogger(applicationClass);

	public static void main(String[] args) {
		SpringApplication.run(applicationClass, args);
	}

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

}
