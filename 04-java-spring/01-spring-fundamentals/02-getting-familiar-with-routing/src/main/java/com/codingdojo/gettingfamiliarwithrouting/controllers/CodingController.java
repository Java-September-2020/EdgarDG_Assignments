package com.codingdojo.gettingfamiliarwithrouting.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodingController {
	@RequestMapping("/")
	public String index() {
		return "Hello Coding Dojo";
	}
	@RequestMapping("python") 
	public String pythonWords() {
		return "Python/Django is awesome!";
	}
	@RequestMapping("/java")
	public String javaWords() {
		return "Java/Spring is better!";
	}
}
