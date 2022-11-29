package com.capg.eLearning.service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.eLearning.entity.Course;
import com.capg.eLearning.exceptions.NoCourseFound;
import com.capg.eLearning.repo.CourseRepo;

@Service
public class CourseService {
	@Autowired
	private CourseRepo repo;
	
	public Course addCourse(Course s) {
		Course t=repo.save(s);
		//System.out.println(t.getName());
		return t;
	}
	
	public List<Course> getAllCourse(){
		List<Course> list=repo.findAll();
		return list;
	}
	
	public Course updateByName(int id,Course c) {
		Optional<Course> oldCourse=repo.findById(id);
		if(!(oldCourse.isPresent())) {
			throw new NoCourseFound("no Course with this id");
		}
		Course oldCourse1=oldCourse.get();
		if(Objects.nonNull(c.getName())) {
			oldCourse1.setName(c.getName());
		}
		
		repo.save(oldCourse1);
		return oldCourse1;
	}
	
	public void deleteCourse(int id){
		Optional<Course> t=repo.findById(id);
		if(t.isPresent()) {
			repo.delete(t.get());
		}
		else {
			throw new NoCourseFound("no Course found with this id");
		}
	}

	public List<Course> getAllCourse1() {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Course> getById(int id) {
		Optional<Course> byName = repo.findById(id);
		return byName;
	}
	
}

