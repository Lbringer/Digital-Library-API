package com.javabackend.digitalLibrary.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
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
public class Student {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int studentId;

	private String name;
	private int age;
	
	@Column(unique = true, nullable = false)
	private String email;

	@OneToMany(mappedBy = "student")
	private List<Book> bookList;

	@OneToMany(mappedBy = "student")
	private List<Transaction> transaction;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;

}
