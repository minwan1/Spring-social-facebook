package com.javacents.socialsignin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class SocialSignInApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialSignInApplication.class, args);
	}
}
