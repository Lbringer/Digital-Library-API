package com.javabackend.digitalLibrary.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

@Entity
public class Author {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int authId;
	
	@Column(name = "myAuthName")
	private String authName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	
	@OneToMany
	private List<Book> bookList; 
	
	
	
	@CreationTimestamp
	private Date createdOn;
	
	
	@UpdateTimestamp
	private Date updatedOn;
}
