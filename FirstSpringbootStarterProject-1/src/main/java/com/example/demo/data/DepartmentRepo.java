package com.example.demo.data;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Department;

public interface DepartmentRepo extends JpaRepository<Department, Long>  {
	
	Department findById(long id);

}
