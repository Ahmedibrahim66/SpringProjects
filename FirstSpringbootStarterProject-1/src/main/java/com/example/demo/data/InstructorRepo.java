package com.example.demo.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.models.Instructor;

public interface InstructorRepo extends PagingAndSortingRepository<Instructor, Long>{
	Instructor findById(long Id);
}
