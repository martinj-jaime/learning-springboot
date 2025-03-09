package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
@EntityScan(basePackages = "com.example.model")
@EnableJpaRepositories(basePackages = "com.example.repositories")
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Spring Version: " + SpringVersion.getVersion() + " SpringBoot Version:" + SpringBootVersion.getVersion());
		SpringApplication.run(DemoApplication.class, args);
	}

}
