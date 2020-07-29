package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.MasStudent;

public interface MasStudentRepo extends JpaRepository<MasStudent, Long>{
	
	MasStudent findById(long Id);


}
