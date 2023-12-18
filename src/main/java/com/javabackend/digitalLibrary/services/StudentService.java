package com.javabackend.digitalLibrary.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javabackend.digitalLibrary.models.Student;
import com.javabackend.digitalLibrary.repos.StudentRepos;

import jakarta.validation.Valid;

@Service
public class StudentService {
	
	@Autowired
	StudentRepos studentRepo;

	public void createStudent(@Valid Student student) {
		studentRepo.save(student);
	}

	public Student getStudentById(int id) {
		return studentRepo.findById(id).orElse(null);
	}

}
