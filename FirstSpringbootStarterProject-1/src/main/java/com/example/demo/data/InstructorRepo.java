package com.example.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Instructor;

public interface InstructorRepo extends PagingAndSortingRepository<Instructor, Long>{
	Instructor findById(long Id);
	
	@Query(nativeQuery = true, value = "DELETE FROM instructors_course WHERE course_id = :id")
	void DeleteInstructorFromCoursesJoinedTable(@Param("id") long id);
	
}
