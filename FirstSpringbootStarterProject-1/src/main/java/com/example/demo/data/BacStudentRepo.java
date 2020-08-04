package com.example.demo.data;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.BacStudent;

public interface BacStudentRepo extends JpaRepository<BacStudent, Long>{

	BacStudent findById(long Id);
	
	@Query("SELECT p FROM BacStudent p Where p.name like %:name% order by p.name DESC")
	List<BacStudent> getCustomQuery(@Param("name") String name  );
	
}
