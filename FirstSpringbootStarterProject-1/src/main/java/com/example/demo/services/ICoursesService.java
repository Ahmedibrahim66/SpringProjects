package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Courses;
import com.example.demo.models.Instructor;

public interface ICoursesService {
	
	public List<Courses> getAllCourses();
	public Courses getCourse(long id);
	public boolean AddCourse(Courses course);
	public boolean UpdateCourse(long id , Courses course);
	public boolean DeleteCourse(long id);
	public boolean AddCourseToDepartment(long id, Courses course);

}
