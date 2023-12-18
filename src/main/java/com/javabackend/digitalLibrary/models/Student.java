package com.javabackend.digitalLibrary.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
public class Student {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int studentId;

	private String name;
	private int age;

	@OneToMany
	private List<Book> bookList;

	@OneToMany
	private List<Transaction> transaction;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;

}
