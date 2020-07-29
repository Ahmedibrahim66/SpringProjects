package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.CoursesRepo;
import com.example.demo.data.DepartmentRepo;
import com.example.demo.models.Courses;
import com.example.demo.models.Department;

@Service
public class CoursesServiceImp implements ICoursesService {

	@Autowired
	CoursesRepo repository;
	
	@Autowired
	DepartmentRepo depRepository;
	

	@Override
	public List<Courses> getAllCourses() {
		List<Courses> coursesList = new ArrayList<>();
		repository.findAll().forEach(coursesList::add);
		return coursesList;
	}

	@Override
	public Courses getCourse(long id) {
		Courses course = repository.findById(id);
		if (course == null)
			throw new EntityNotFoundException("No course with Id = " + id + "  is found");
		else
			return course;

	}

	@Override
	public boolean AddCourse(Courses course) {
		try {
			repository.save(course);
			return true;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public boolean UpdateCourse(long id, Courses course) {

		Courses courseFromRep = repository.findById(id);
		if (courseFromRep == null)
			throw new EntityNotFoundException("No course with Id = " + id + "  is found");
		else {
			try {
				BeanUtils.copyProperties(course, courseFromRep);
				repository.save(courseFromRep);
				return true;
			} catch (Exception e) {
				throw e;
			}
		}
	}

	@Override
	public boolean DeleteCourse(long id) {
		Courses course = repository.findById(id);
		if (course == null)
			throw new EntityNotFoundException("No course with Id = " + id + "  is found");
		else {
			repository.deleteById(id);
			return true;
		}

	}

	@Override
	public boolean AddCourseToDepartment(long id, Courses course) {
		Department department = depRepository.findById(id);
		if(department == null)
			throw new EntityNotFoundException("No department with Id = " + id + "  is found");
		else {
			course.setDepartment(department);
			repository.save(course);
			department.getCourses().add(course);
			depRepository.save(department);
			return true;	
		}
	}

}
