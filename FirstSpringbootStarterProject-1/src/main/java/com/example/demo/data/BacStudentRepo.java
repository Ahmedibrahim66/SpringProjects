package com.example.demo.data;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.models.BacStudent;

@Repository
public interface BacStudentRepo extends JpaRepository<BacStudent, Long>{

	BacStudent findById(long Id);
	
	@Query(nativeQuery = true, value = "DELETE FROM bac_student_course WHERE course_id = :id")
	void DeleteBacStudentFromCoursesJoinedTable(@Param("id") long id);
	
	@Query("SELECT p FROM BacStudent p Where p.name like %:name% order by p.name DESC")
	List<BacStudent> getCustomQuery(@Param("name") String name  );
	
	
	@Query(nativeQuery = true, value = "SELECT * FROM bac_students")
	List<BacStudent> getCustomNativeQuery();
	
	
	@Query(nativeQuery = true , value = "select MAX(gpa) from bac_students")
	double getHighestGPA();
	
	@Query(nativeQuery = true , value = "SELECT COUNT(id) FROM bac_students")
	int getStudetCount();
	
	
	//course_id column is actually bac_student_id column but its inverted 
	@Query(nativeQuery = true , value = "SELECT * FROM bac_students WHERE id NOT IN (SELECT course_id FROM bac_student_course)")
	List<BacStudent> getStudentsWithNoCourses();
	
	
}
