package com.edgar.show.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edgar.show.models.Book;
import com.edgar.show.services.BookService;

@Controller
public class BookController {
	@Autowired
	private BookService bservice;

	@RequestMapping("/")
	public String index(Model viewModel) {
		List<Book> allBooks = this.bservice.getAllBooks();
		viewModel.addAttribute("allBooks", allBooks);
		return "index.jsp";
	}
	
	@RequestMapping("/add")
	public String addBook(@Valid @ModelAttribute("book") Book book) {
		return "add.jsp";
	}
	
	@RequestMapping("/{id}")
	public String getBook(@PathVariable("id") Long id, Model viewModel,@Valid @ModelAttribute("book") Book book) {
		viewModel.addAttribute("book", this.bservice.getOneBook(id));
		return "show.jsp";
	}

	@RequestMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long id,@Valid @ModelAttribute("book") Book book, Model viewModel) {
		viewModel.addAttribute("book", this.bservice.getOneBook(id));
		return "edit.jsp";
	}
	
	@PostMapping("/book")
	public String addBook(@Valid @ModelAttribute("book") Book newBook, BindingResult result) {
		if (result.hasErrors()) {
			return "add.jsp";
		} else {
			this.bservice.createBook(newBook);
			return "redirect:/";
		}
	}
	
	@PostMapping("/edit/{id}")
	public String editBook(@PathVariable("id") Long id,@Valid @ModelAttribute("book") Book updatedBook, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			this.bservice.updateBook(updatedBook);
			return "redirect:/";
		}
	}
	
	@PostMapping("/delete/{id}")
	public String deleteBook(@PathVariable("id") Long id,@Valid @ModelAttribute("book") Book updatedBook, BindingResult result) {
		if (result.hasErrors()) {
			return "edit.jsp";
		} else {
			this.bservice.deleteBook(id);
			return "redirect:/";
		}
	}
	
}
