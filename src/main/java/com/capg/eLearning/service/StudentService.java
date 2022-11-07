package com.capg.eLearning.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.eLearning.entity.Student;
import com.capg.eLearning.exceptions.NoStudentFound;
import com.capg.eLearning.repo.StudentRepo;

@Service
public class StudentService {
	@Autowired
	private StudentRepo repo;
	
	public Student addStudent(Student s) {
		Student t=repo.save(s);
		//System.out.println(t.getId());
		return t;
	}
	
	public List<Student> getAllStudent(){
		List<Student> list=repo.findAll();
		return list;
	}
	
	public Student updateById(int id,Student m) {
		Optional<Student> oldStudent1=repo.findById(id);
		if(!(oldStudent1.isPresent())) {
			throw new NoStudentFound("no student with this id");
		}
		Student oldStudent=oldStudent1.get();
		if(Objects.nonNull(m.getFname())) {
			oldStudent.setFname(m.getFname());
		}
		if(Objects.nonNull(m.getLname())) {
			oldStudent.setLname(m.getLname());
		}
		if(Objects.nonNull(m.getPassword())) {
			oldStudent.setPassword(m.getPassword());
		}
		if(Objects.nonNull(m.getPhone())) {
			oldStudent.setPhone(m.getPhone());
		}
		if(Objects.nonNull(m.getAddress())) {
			oldStudent.setAddress(m.getAddress());
		}
		
		repo.save(oldStudent);
		return oldStudent;
	}
	
	public void deleteStudent(int id){
		Optional<Student> t=repo.findById(id);
		if(t.isPresent()) {
			repo.deleteById(id);
		}
		else {
			throw new NoStudentFound("no student found with this id");
		}
	}
	
}
