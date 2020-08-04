package com.example.demo.services;

import java.util.List;

import com.example.demo.models.BacStudent;


public interface IBacStudentService  {
	
	public List<BacStudent> getAllBacStudents();
	public BacStudent getBacStudent(long id);
	public boolean AddBacStudent(BacStudent student);
	public boolean UpdateBacStudent(long id , BacStudent student);
	public boolean DeleteBacStudent(long id);
	public boolean AddCourseToStudent(long courseId, long bacStudentId);
	public List<BacStudent> getCustomQuery(String chars);
	
}
