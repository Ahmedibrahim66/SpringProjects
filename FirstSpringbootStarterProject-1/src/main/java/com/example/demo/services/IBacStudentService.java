package com.example.demo.services;

import java.util.List;

import com.example.demo.models.BacStudent;


public interface IBacStudentService  {
	
	public List<BacStudent> getAllBacStudents(int page, int size);
	public BacStudent getBacStudent(long id);
	public boolean AddBacStudent(BacStudent student);
	public boolean UpdateBacStudent(long id , BacStudent student);
	public boolean DeleteBacStudent(long id);
	public boolean AddCourseToStudent(long courseId, long bacStudentId);
	public List<BacStudent> getCustomQuery(String chars);
	public List<BacStudent> getCustomNativeQuery(int size, int page);
	public double getHighestGPA();
	public int getStudetCount();
	public List<BacStudent> getStudentsWithNoCourses();
	

}
