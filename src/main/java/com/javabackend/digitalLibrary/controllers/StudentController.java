package com.javabackend.digitalLibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javabackend.digitalLibrary.createRequest.StudentReq;
import com.javabackend.digitalLibrary.models.Student;
import com.javabackend.digitalLibrary.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@PostMapping("/create")
	public void createStudent(@Valid @RequestBody StudentReq studentReq) {
		studentService.createStudent(studentReq.to());
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable("id") int id) {
		return studentService.getStudentById(id);
	}
	
	
	
}
