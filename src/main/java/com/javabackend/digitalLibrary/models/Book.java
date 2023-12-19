package com.javabackend.digitalLibrary.models;


import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Book {
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String name;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "bookList")
	private Author myAuthor;
	
	
	@Enumerated(value = EnumType.STRING)
	private Genre genre;
	
	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "bookList")
	private Student student;
	
	@OneToMany(mappedBy = "book")
	@JsonIgnoreProperties(value = "book")
	private List<Transaction> transactions;
	
	@CreationTimestamp
	private Date createdDate;
	
	@UpdateTimestamp
	private Date updatedDate; 
	
}
