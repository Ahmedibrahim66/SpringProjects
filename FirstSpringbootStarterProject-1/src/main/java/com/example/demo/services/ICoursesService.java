package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Courses;

public interface ICoursesService {
	
	public List<Courses> getAllCourses(int page, int size);
	public Courses getCourse(long id);
	public boolean AddCourse(Courses course);
	public boolean UpdateCourse(long id , Courses course);
	public boolean DeleteCourse(long id);
	public boolean AddCourseToDepartment(long id, long courseId);

}
