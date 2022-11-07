package com.capg.eLearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.eLearning.entity.Faculty;

@Repository
public interface FacultyRepo extends JpaRepository<Faculty,Integer>{

}
