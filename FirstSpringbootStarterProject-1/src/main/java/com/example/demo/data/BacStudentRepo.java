package com.example.demo.data;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.BacStudent;

public interface BacStudentRepo extends JpaRepository<BacStudent, Long>{

	BacStudent findById(long Id);
	
}
