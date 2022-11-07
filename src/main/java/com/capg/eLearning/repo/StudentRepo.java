package com.capg.eLearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.eLearning.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer>{

}
