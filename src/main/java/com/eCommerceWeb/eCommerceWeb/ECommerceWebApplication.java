package com.eCommerceWeb.eCommerceWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ECommerceWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ECommerceWebApplication.class, args);
	}

}
