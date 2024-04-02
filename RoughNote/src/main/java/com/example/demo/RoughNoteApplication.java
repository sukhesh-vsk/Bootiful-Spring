package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, SecurityAutoConfiguration.class})
@ComponentScan("com.example.demo.controller")
@EntityScan("com.example.demo.model")
@EnableJpaRepositories("com.example.demo.repository")
public class RoughNoteApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RoughNoteApplication.class, args);
	}
	
	
}
