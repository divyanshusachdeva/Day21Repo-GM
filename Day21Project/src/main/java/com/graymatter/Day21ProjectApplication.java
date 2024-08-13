package com.graymatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class Day21ProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day21ProjectApplication.class, args);
		System.out.println("My first Springboot app started");
	}

}
