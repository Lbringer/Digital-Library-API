package com.javabackend.digitalLibrary.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.javabackend.digitalLibrary.models.Author;

public interface AuthorRepos extends JpaRepository<Author, Integer> {

	
	@Query(value = "select a from Author a where a.email= :email")
	Author findAuthor(String email);
	
}
