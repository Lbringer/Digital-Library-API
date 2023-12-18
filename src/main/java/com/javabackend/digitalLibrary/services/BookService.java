package com.javabackend.digitalLibrary.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabackend.digitalLibrary.models.Author;
import com.javabackend.digitalLibrary.models.Book;
import com.javabackend.digitalLibrary.repos.BookRepos;

@Service
public class BookService {
	
	@Autowired
	BookRepos bookRepos;
	
	@Autowired
	AuthorService authorService;

	public void createBook(Book book) {
		 Author author = authorService.createOrGetAuthor(book.getMyAuthor());
	}

	public List<Book> getAllBooks() {
		return null;
	}

	public Book getBookById(int id) {
		return null;
	}

}
