package com.example.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.MasStudent;

public interface MasStudentRepo extends PagingAndSortingRepository<MasStudent, Long>{
	
	MasStudent findById(long Id);
	
	@Query(nativeQuery = true, value = "DELETE FROM mas_student_course WHERE course_id = :id")
	void DeleteMasStudentFromCoursesJoinedTable(@Param("id") long id);
	


}
