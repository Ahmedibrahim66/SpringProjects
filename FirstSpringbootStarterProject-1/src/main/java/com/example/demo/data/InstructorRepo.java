package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Instructor;

public interface InstructorRepo extends JpaRepository<Instructor, Long>{
	Instructor findById(long Id);
}
