package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Courses;

public interface CoursesRepo extends JpaRepository<Courses, Long>{
	
	Courses findById(long Id);

}
