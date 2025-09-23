package com.javatechie.jenkin.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringJenkinsApplication extends SpringBootServletInitializer {

	//“Extending SpringBootServletInitializer and overriding configure() allows a Spring Boot
	// application to be deployed as a WAR on an external servlet container like Tomcat,
	// specifying the main application class for initialization.
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SpringJenkinsApplication.class);
	}
	@GetMapping("/ping")
	public String message() {
		return "Wao!! Application Deployed successfully in SAP Cloud..";
	}

	@GetMapping("/hello")
	public String hello() {
		return "Hi Jenkins How are you..";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Hi Jenkins welcome.";
	}


	@GetMapping("/welcomeMessage")
	public String welcomeMessage() {
		return "Hi Jenkins welcomeMessage.";
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringJenkinsApplication.class, args);
	}

}
