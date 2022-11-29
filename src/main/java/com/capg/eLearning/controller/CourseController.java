package com.capg.eLearning.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.eLearning.entity.Course;
import com.capg.eLearning.service.CourseService;

@RestController
@RequestMapping(value = "/library/author")
public class CourseController {
	@Autowired
	private CourseService service;
	
	@PostMapping(value="/addCourse")
	public ResponseEntity<Object> addStudent(@RequestBody Course d){
		Course a=service.addCourse(d);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
	@GetMapping(value="/getAllCourses")
	public ResponseEntity<Object> getAllCourse(){
		List<Course> ls=service.getAllCourse();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ls);
	}
	@PostMapping(value="/getById")
	public ResponseEntity<Object> getByName(@RequestBody int id){
		Optional<Course> a=service.getById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
	
	
}
