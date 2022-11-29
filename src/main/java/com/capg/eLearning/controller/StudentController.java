package com.capg.eLearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.eLearning.entity.Student;
import com.capg.eLearning.service.StudentService;

@RestController
@RequestMapping(value="/eLearning/Student/")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping(value="/addStudent")
	public ResponseEntity<Object> addStudent(@RequestBody Student d){
		Student a=service.addStudent(d);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
	@GetMapping(value="/getAllStudents")
	public ResponseEntity<Object> getAllStudent(){
		List<Student> ls=service.getAllStudent();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ls);
	}
	
	@GetMapping(value="/getStudentById/{id}")
	public ResponseEntity<Object> getStudentById(@PathVariable("id") int id){
		Student ls=service.getStudentById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ls);
	}
	
	@PutMapping(value="/updateById/{id}")
	public ResponseEntity<Student> updateByid(@PathVariable("id") int id,@RequestBody Student m){
		Student newStudent=service.updateById(id, m);
		return ResponseEntity.status(HttpStatus.OK).body(newStudent);
	}
	
	@DeleteMapping(value="/deleteById/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable("id")int id){
		Student s=service.deleteStudent(id);
		return ResponseEntity.status(HttpStatus.OK).body(s);
	}
	
	@PostMapping(value="/addBulkStudent")
	public ResponseEntity<Object> addBulkStudent(@RequestBody Student[] d){
		Student[] a=service.addBulkStudent(d);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
}
