package com.example.demo.data;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.example.demo.models.Department;

public interface DepartmentRepo extends PagingAndSortingRepository<Department, Long>  {
	
	Department findById(long id);

}
