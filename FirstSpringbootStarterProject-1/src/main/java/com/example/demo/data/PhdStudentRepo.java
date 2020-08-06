package com.example.demo.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.models.PHDStudent;

public interface PhdStudentRepo extends PagingAndSortingRepository<PHDStudent, Long> {
	
	PHDStudent findById(long Id);

}
