package com.hlechuga.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@RestController
public class Application {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
	  
	public static void main(String[] args) {    
    	SpringApplication.run(Application.class, args);
  	}
}