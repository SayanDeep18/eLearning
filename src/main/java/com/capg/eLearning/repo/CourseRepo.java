package com.capg.eLearning.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.eLearning.entity.Course;

@Repository
public interface CourseRepo extends JpaRepository<Course,Integer>{

}
