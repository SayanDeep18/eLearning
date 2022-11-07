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

import com.capg.eLearning.entity.Admin;
import com.capg.eLearning.service.AdminService;

@RestController
@RequestMapping(value="/eLearning/Admin")
public class adminController {
	@Autowired
	private AdminService service;
	
	@PostMapping(value="/addAdmin")
	public ResponseEntity<Object> addAdmin(@RequestBody Admin d){
		Admin a=service.addAdmin(d);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
	@GetMapping(value="/getAllAdmins")
	public ResponseEntity<Object> getAllAdmins(){
		List<Admin> ls=service.getAllAdmin();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(ls);
	}
	
	@PutMapping(value="/updateById/{id}")
	public ResponseEntity<Object> updateByid(@PathVariable("id") int id,@RequestBody Admin m){
		Admin newAdmin=service.updateById(id, m);
		return ResponseEntity.status(HttpStatus.OK).body(newAdmin);
	}
	
	@DeleteMapping(value="/deleteById/{id}")
	public ResponseEntity<Object> deleteById(@PathVariable("id")int id){
		service.deleteAdmin(id);
		return ResponseEntity.status(HttpStatus.OK).body("Student deleted");
	}
}
