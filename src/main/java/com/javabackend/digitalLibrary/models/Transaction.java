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
public class Transaction {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	
	private String transactionId;

	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "transaction")
	private Student student;

	private Integer fine;

	@Enumerated(value = EnumType.STRING)
	private TransactionType transactionType;

	@Enumerated(value = EnumType.STRING)
	private TransactionStatus transcationStatus;

	@ManyToOne
	@JoinColumn
	@JsonIgnoreProperties(value = "transactions")
	private Book book;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;
}
