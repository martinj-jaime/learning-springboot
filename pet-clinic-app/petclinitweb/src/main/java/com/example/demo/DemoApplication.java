package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println("Spring Version: " + SpringVersion.getVersion() + " SpringBoot Version:" + SpringBootVersion.getVersion());
		SpringApplication.run(DemoApplication.class, args);
	}

}
