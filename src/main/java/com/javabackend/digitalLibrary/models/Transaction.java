package com.javabackend.digitalLibrary.models;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Transaction {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;

	@ManyToOne
	@JoinColumn
	private Student student;

	private Integer fine;

	@Enumerated(value = EnumType.STRING)
	private TransactionType transactionType;

	@Enumerated(value = EnumType.STRING)
	private TransactionStatus transcationStatus;

	@ManyToOne
	@JoinColumn
	private Book book;

	@CreationTimestamp
	private Date createdOn;

	@UpdateTimestamp
	private Date updatedOn;
}
