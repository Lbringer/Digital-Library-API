package com.javabackend.digitalLibrary.controllers;


import java.util.List;

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



@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;

	@PostMapping("/create")
	public void createStudent(@RequestBody StudentReq studentReq) {
		studentService.createStudent(studentReq.to());
	}
	
	@GetMapping("/all")
	public List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
	
	@GetMapping("/{id}")
	public Student getStudentById(@PathVariable("id") int id) {
		return studentService.getStudentById(id);
	}
	
}
