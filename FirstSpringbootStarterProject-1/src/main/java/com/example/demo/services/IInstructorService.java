package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Instructor;

public interface IInstructorService {

	public List<Instructor> getAllInstructors();
	public Instructor getInstructor(long id);
	public boolean AddInstructor(Instructor instructor);
	public boolean UpdateInstructor(long id , Instructor instructor);
	public boolean DeleteInstructor(long id);
	public boolean AddInstructorToDepartment(long id, Instructor instructor);
	public boolean AddInstructorToCourse(long courseId, long instructorId);

}
