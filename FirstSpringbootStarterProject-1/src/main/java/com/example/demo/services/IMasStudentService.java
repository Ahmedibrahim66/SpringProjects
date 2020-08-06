package com.example.demo.services;

import java.util.List;

import com.example.demo.models.MasStudent;

public interface IMasStudentService {

	public List<MasStudent> getAllMasStudents(int page, int size);
	public MasStudent getMasStudent(long id);
	public boolean AddMasStudent(MasStudent masStudent);
	public boolean UpdateMasStudent(long id , MasStudent masStudent);
	public boolean DeleteMasStudent(long id);
	public boolean AddCourseToStudent(long courseId, long masStudentId);

}
