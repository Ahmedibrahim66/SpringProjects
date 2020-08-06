package com.example.demo.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.models.Courses;

public interface CoursesRepo extends PagingAndSortingRepository<Courses, Long>{
	
	Courses findById(long Id);

}
