package com.capg.eLearning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToOne
	private Faculty faculty;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Faculty getFaculty() {
		return faculty;
	}
	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}
	public Course(String name, Faculty faculty) {
		super();
		this.name = name;
		this.faculty = faculty;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
