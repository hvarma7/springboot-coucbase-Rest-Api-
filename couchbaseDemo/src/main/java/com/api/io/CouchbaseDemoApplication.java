package com.api.io;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan(basePackages= {"com.employee.config","com.employee.controller",
		"com.employee.dao","com.employee.service"})
//@PropertySource("/Users/hrishikeshvarma/config/application.properties")
public class CouchbaseDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouchbaseDemoApplication.class, args);
	}

}

