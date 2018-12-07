package com.tamdongtam.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan({ "com.tamdongtam.java" })
public class InternJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternJavaApplication.class, args);
	}
}
