package com.capg.eLearning.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.eLearning.entity.Faculty;
import com.capg.eLearning.exceptions.NoFacultyFound;
import com.capg.eLearning.repo.FacultyRepo;

@Service
public class FacultyService {
	@Autowired
	private FacultyRepo repo;
	
	public Faculty addFaculty(Faculty a) {
		Faculty t=repo.save(a);
		return t;
	}
	
	public List<Faculty> getAllFaculty(){
		List<Faculty> ls=repo.findAll();
		return ls;
	}
	
	public Faculty updateById(int id,Faculty m) {
		Optional<Faculty> oldAdmin1=repo.findById(id);
		if(!(oldAdmin1.isPresent())) {
			throw new NoFacultyFound("no faculty with this id");
		}
		Faculty oldAdmin=oldAdmin1.get();
		if(Objects.nonNull(m.getFname())) {
			oldAdmin.setFname(m.getFname());
		}
		if(Objects.nonNull(m.getLname())) {
			oldAdmin.setLname(m.getLname());
		}
		if(Objects.nonNull(m.getPhone())) {
			oldAdmin.setPhone(m.getPhone());
		}
		
		repo.save(oldAdmin);
		return oldAdmin;
	}
	
	public void deleteFaculty(int id){
		Optional<Faculty> t=repo.findById(id);
		if(t.isPresent()) {
			repo.deleteById(id);
		}
		else {
			throw new NoFacultyFound("no faculty found with this id");
		}
	}
}
