package com.example.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.PHDStudent;

public interface PhdStudentRepo extends PagingAndSortingRepository<PHDStudent, Long> {
	
	PHDStudent findById(long Id);

	@Query(nativeQuery = true, value = "DELETE FROM phd_student_course WHERE course_id = :id")
	void DeletePhdStudentFromCoursesJoinedTable(@Param("id") long id);
	
}
