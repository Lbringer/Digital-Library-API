package com.javabackend.digitalLibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javabackend.digitalLibrary.services.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/issue")
	public String issueBook(@RequestParam("bookId") int bookId,@RequestParam("studentId") int studentId) throws Exception {
		return transactionService.issueBook(bookId,studentId);
	}
	@PostMapping("/return")
	public String returnBook(@RequestParam("bookId") int bookId,@RequestParam("studentId") int studentId) throws Exception {
		return transactionService.returnBook(bookId,studentId);
	}
	
}
