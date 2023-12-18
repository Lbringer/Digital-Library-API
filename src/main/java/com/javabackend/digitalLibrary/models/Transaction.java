package com.javabackend.digitalLibrary.models;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
public class Transaction {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;

	@ManyToOne
	private Student student;

	private Integer fine;

	private TransactionType transactionType;

	private TransactionStatus transcationStatus;

	@ManyToOne
	private Book book;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;
}
