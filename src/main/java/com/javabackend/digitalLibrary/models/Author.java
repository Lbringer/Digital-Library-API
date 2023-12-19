package com.javabackend.digitalLibrary.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
public class Author {
	
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int authId;
	
	
	
	@Column(name = "myAuthName",length = 15)
	private String authName;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	
	@OneToMany(mappedBy = "myAuthor")
	@JsonIgnoreProperties(value = {"myAuthor","createdOn","updatedOn"})
	private List<Book> bookList; 
	
	
	
	@CreationTimestamp
	private Date createdOn;
	
	
	@UpdateTimestamp
	private Date updatedOn;
}
