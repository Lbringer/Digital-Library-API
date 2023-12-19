package com.javabackend.digitalLibrary.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.javabackend.digitalLibrary.createRequest.BookReq;
import com.javabackend.digitalLibrary.models.Book;
import com.javabackend.digitalLibrary.services.BookService;


@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	
	@PostMapping("/create")
	public void createBook(@RequestBody BookReq bookReq) {
		bookService.createBook(bookReq.to());
	}
	
	@GetMapping("/all")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return bookService.getBookById(id);
	}
	
	
}
