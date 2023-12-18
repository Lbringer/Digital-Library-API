package com.javabackend.digitalLibrary.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabackend.digitalLibrary.models.Book;

public interface BookRepos extends JpaRepository<Book, Integer> {

}
