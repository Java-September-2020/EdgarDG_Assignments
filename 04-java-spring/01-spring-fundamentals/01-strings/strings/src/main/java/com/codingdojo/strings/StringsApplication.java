package com.codingdojo.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}

	
	@RequestMapping("/")
	public String index () {
		return "Wake up, client. The Matrix has you..... follow the white rabbit.";
	}
	@RequestMapping("/random")
	public String randomPage () {
		return "Spring Boot is the Bees' Knees!!";
	}
}
