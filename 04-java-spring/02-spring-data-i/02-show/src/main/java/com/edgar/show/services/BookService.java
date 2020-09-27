package com.edgar.show.services;

import org.springframework.stereotype.Service;
import java.util.List;

import com.edgar.show.models.Book;
import com.edgar.show.repositories.BookRepository;

@Service
public class BookService {
	private BookRepository bRepo;
	public BookService (BookRepository repo) {
		this.bRepo = repo;
	}
	
	//show all books
	public List<Book> getAllBooks() {
		return this.bRepo.findAll();
	}
	//Get One Book
	public Book getOneBook(Long id) {
		return this.bRepo.findById(id).orElse(null);
	}
	
	//Create a Book
	public Book createBook(Book newBook) {
		return this.bRepo.save(newBook);
	}
	
	//Update a Book
	public Book updateBook(Book updatedBook) {
		return this.bRepo.save(updatedBook);
	}

	
	//Delete Book
	public void deleteBook(Long id) {
		this.bRepo.deleteById(id);
	}
	
}
