package com.capg.eLearning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String fname;
	
	private String lname;
	
	private String phone;
	
	private String address;
	
	private String password;
	
	public int getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Student(String fname, String lname, String phone, String address,String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.address = address;
		this.password=password;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
