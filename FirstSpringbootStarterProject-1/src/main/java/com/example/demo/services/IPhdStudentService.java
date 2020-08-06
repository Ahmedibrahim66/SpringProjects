package com.example.demo.services;

import java.util.List;
import com.example.demo.models.PHDStudent;

public interface IPhdStudentService {

	public List<PHDStudent> getAllPhdStudents(int page, int size);
	public PHDStudent getPhdStudent(long id);
	public boolean AddPhdStudent(PHDStudent phdStudent);
	public boolean UpdatePhdStudent(long id , PHDStudent phdStudent);
	public boolean DeletePhdStudent(long id);
	public boolean AddCourseToStudent(long courseId, long phdStudentId);

}
