package com.capg.eLearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.eLearning.entity.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer>{

}
