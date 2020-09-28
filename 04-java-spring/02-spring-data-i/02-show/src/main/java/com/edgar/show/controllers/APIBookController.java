package com.edgar.show.controllers;

import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.PUT)
	public Book editBook(@PathVariable("id") Long id, @ModelAttribute("book") Book updatedBook) {
			return this.bservice.updateBook(updatedBook);
		}

	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public String deleteBook(@PathVariable("id") Long id, @ModelAttribute("book") Book updatedBook) {
			this.bservice.deleteBook(id);
			return id + " has been deleted from the database.";
				}	
	
	
}
