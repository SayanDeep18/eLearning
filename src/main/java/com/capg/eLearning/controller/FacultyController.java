package com.capg.eLearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.eLearning.entity.Faculty;
import com.capg.eLearning.service.FacultyService;

@RestController
@RequestMapping(value="eLearning/Faculty/")
public class FacultyController {
	@Autowired
	private FacultyService service;
	
	@PostMapping(value="/addFaculty")
	public ResponseEntity<Object> addFaculty(@RequestBody Faculty d){
		Faculty a=service.addFaculty(d);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
	@GetMapping(value="/getAllFaculty")
	public ResponseEntity<Object> getAllFaculty(){
		List<Faculty> ls=service.getAllFaculty();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ls);
	}
	
	@PutMapping(value="/updateById/{id}")
	public ResponseEntity<Faculty> updateByid(@PathVariable("id") int id,@RequestBody Faculty m){
		Faculty newFaculty=service.updateById(id, m);
		return ResponseEntity.status(HttpStatus.OK).body(newFaculty);
	}
	
	@DeleteMapping(value="/deleteById/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable("id")int id){
		service.deleteFaculty(id);
		return ResponseEntity.status(HttpStatus.OK).body("Faculty deleted");
	}
}
