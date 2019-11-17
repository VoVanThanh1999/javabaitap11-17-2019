package com.example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.example.model")
@EnableJpaRepositories("com.example.repository")
@ComponentScan("com.example.serivce")
@ComponentScan("com.example.repository")
@ComponentScan("com.example.securityconfig")
@ComponentScan("com.example.student_resources")
@ComponentScan("com.example.dto")
@SpringBootApplication
public class BaiTapJavaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaiTapJavaApplication.class, args);
	}

}
