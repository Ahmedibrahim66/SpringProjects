package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.PHDStudent;

public interface PhdStudentRepo extends JpaRepository<PHDStudent, Long> {
	
	PHDStudent findById(long Id);

}
