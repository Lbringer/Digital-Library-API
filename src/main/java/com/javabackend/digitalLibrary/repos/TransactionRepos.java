package com.javabackend.digitalLibrary.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabackend.digitalLibrary.models.Book;
import com.javabackend.digitalLibrary.models.Student;
import com.javabackend.digitalLibrary.models.Transaction;
import com.javabackend.digitalLibrary.models.TransactionType;

public interface TransactionRepos extends JpaRepository<Transaction, Integer>{

	List<Transaction> findByStudentAndBookAndTransactionTypeOrderByIdDesc(Student student,Book book,TransactionType transactionType);
}
