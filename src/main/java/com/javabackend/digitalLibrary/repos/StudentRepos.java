package com.javabackend.digitalLibrary.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabackend.digitalLibrary.models.Student;


public interface StudentRepos extends JpaRepository<Student, Integer> {

}
