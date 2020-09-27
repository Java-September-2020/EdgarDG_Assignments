package com.edgar.show.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edgar.show.models.Book;
import com.edgar.show.services.BookService;

@RestController
@RequestMapping("/api")
public class APIBookController {
	private BookService bservice;
	public APIBookController (BookService service) {
		this.bservice = service;
	}
	
	//Routes
	@RequestMapping("/")
	public List<Book> index() {
		return this.bservice.getAllBooks();
	}
	
	@RequestMapping("{id}")
	public Book getBook(@PathVariable("id") Long id) {
		return this.bservice.getOneBook(id);
	}
	
	
	
}
