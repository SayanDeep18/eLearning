package com.capg.eLearning.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.eLearning.entity.Admin;
import com.capg.eLearning.exceptions.NoAdminFound;
import com.capg.eLearning.repo.AdminRepo;

@Service
public class AdminService {
	@Autowired
	private AdminRepo repo;
	
	public Admin addAdmin(Admin a) {
		Admin t=repo.save(a);
		return t;
	}
	
	public List<Admin> getAllAdmin(){
		List<Admin> ls=repo.findAll();
		return ls;
	}
	
	public Admin updateById(int id,Admin m) {
		Optional<Admin> oldAdmin1=repo.findById(id);
		if(!(oldAdmin1.isPresent())) {
			throw new NoAdminFound("no admin with this id");
		}
		Admin oldAdmin=oldAdmin1.get();
		if(Objects.nonNull(m.getFname())) {
			oldAdmin.setFname(m.getFname());
		}
		if(Objects.nonNull(m.getLname())) {
			oldAdmin.setLname(m.getLname());
		}
		if(Objects.nonNull(m.getPassword())) {
			oldAdmin.setPassword(m.getPassword());
		}
		
		repo.save(oldAdmin);
		return oldAdmin;
	}
	
	public void deleteAdmin(int id){
		Optional<Admin> t=repo.findById(id);
		if(t.isPresent()) {
			repo.deleteById(id);
		}
		else {
			throw new NoAdminFound("no admin found with this id");
		}
	}
}
