package com.skct.cc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class Cc2Application {

	public static void main(String[] args) {
		SpringApplication.run(Cc2Application.class, args);
	}

}
