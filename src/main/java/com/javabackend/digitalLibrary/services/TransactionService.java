package com.javabackend.digitalLibrary.services;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.javabackend.digitalLibrary.models.*;
import com.javabackend.digitalLibrary.models.Student;
import com.javabackend.digitalLibrary.models.Transaction;
import com.javabackend.digitalLibrary.repos.TransactionRepos;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepos transactionRepos; 
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	BookService bookService;
	
	@Value("${student.book.limit}")
	int studentBookLimit;
	
	@Value("${book.return.days}")
	int bookReturnDays;
	
	@Value("${book.fine.day}")
	int finePerDay;

	public String issueBook(int bookId, int studentId) throws Exception {
		
		Student student = studentService.getStudentById(studentId);
		
		if(student == null) {
			throw new Exception("Student is not prsent , unable to issue book");
		}
		
		if(student.getBookList().size()>=studentBookLimit) {
			throw new Exception("Student has reached their limit , unable to issue book");
		}
		
		Book book = bookService.getBookById(bookId);
		
		if(book == null) {
			throw new Exception("Book is not prsent , unable to issue book");
		}
		
		if(book.getStudent()!=null) {
			throw new Exception("Book already issued , unable to issue book");
		}
		
		
		Transaction transaction = Transaction.builder()
				.book(book)
				.student(student)
				.transactionType(TransactionType.ISSUE)
				.transcationStatus(TransactionStatus.PENDING)
				.transactionId(UUID.randomUUID().toString())
				.build();
		
		transactionRepos.save(transaction);
		
		try {
			
			book.setStudent(student);
			bookService.createBook(book);
			
			transaction.setTranscationStatus(TransactionStatus.SUCCESS);
			
			transactionRepos.save(transaction);
		} catch (Exception e) {
			book.setStudent(null);
			bookService.createBook(book);
			
			transaction.setTranscationStatus(TransactionStatus.FAILED);
			transactionRepos.save(transaction);
			
		}
		 
		return transaction.getTransactionId()+" "+"Issue Method";
	}

	public String returnBook(int bookId, int studentId) throws Exception {
		
		Student student = studentService.getStudentById(studentId);
		
		Book book = bookService.getBookById(bookId);
		
		if(book == null || student == null || book.getStudent() == null || book.getStudent().getStudentId()!=studentId) {
			throw new Exception("Book or student is not prsent , or book is not assigned to the student, Unable to return the book");
		}
		
		 Transaction issueTnx = transactionRepos
				 .findByStudentAndBookAndTransactionTypeOrderByIdDesc(student, book, TransactionType.ISSUE)
				 .get(0);
		 
		 long issueTimeMs = issueTnx.getUpdatedOn().getTime();
		 long currentTimeMs = System.currentTimeMillis();
		 
		 long difInMs = currentTimeMs-issueTimeMs;
		 
		 long difInDays = TimeUnit.DAYS.convert(difInMs,TimeUnit.MILLISECONDS);
		 
		 int fine = 0;
		 
		 if(difInDays>bookReturnDays) {
			 fine = (int) ((difInDays-bookReturnDays)*finePerDay);
		 }
		
		 Transaction transaction = Transaction.builder()
					.book(book)
					.student(student)
					.fine(fine)
					.transactionType(TransactionType.RETURN)
					.transcationStatus(TransactionStatus.PENDING)
					.transactionId(UUID.randomUUID().toString())
					.build();
			
		transactionRepos.save(transaction);
		
		
		
		try {
			book.setStudent(null);
			bookService.createBook(book);
			
			transaction.setTranscationStatus(TransactionStatus.SUCCESS);
			transactionRepos.save(transaction);
			
		} catch (Exception e) {
			book.setStudent(student);
			bookService.createBook(book);
			
			transaction.setTranscationStatus(TransactionStatus.FAILED);
			
			transactionRepos.save(transaction);
			
		}
		return transaction.getTransactionId();
	}
 
}
