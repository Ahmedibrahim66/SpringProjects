package com.example.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.Courses;

public interface CoursesRepo extends PagingAndSortingRepository<Courses, Long>{
	
	Courses findById(long Id);
	
	@Query(nativeQuery = true, value = "DELETE FROM bac_student_course WHERE bac_student_id = :id")
	void DeleteBacStudentFromCoursesJoinedTable(@Param("id") long id);
	
	@Query(nativeQuery = true, value = "DELETE FROM mas_student_course WHERE mas_student_id = :id")
	void DeleteMasStudentFromCoursesJoinedTable(@Param("id") long id);
	
	@Query(nativeQuery = true, value = "DELETE FROM phd_student_course WHERE phd_student_id = :id")
	void DeletePhdStudentFromCoursesJoinedTable(@Param("id") long id);
	


}
