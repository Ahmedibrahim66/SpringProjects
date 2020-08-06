package com.example.demo.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.models.MasStudent;

public interface MasStudentRepo extends PagingAndSortingRepository<MasStudent, Long>{
	
	MasStudent findById(long Id);


}
