package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.data.CoursesRepo;
import com.example.demo.data.DepartmentRepo;
import com.example.demo.data.InstructorRepo;
import com.example.demo.models.Courses;
import com.example.demo.models.Department;
import com.example.demo.models.Instructor;

@Service
public class InstructorServiceImp implements IInstructorService {

	@Autowired
	InstructorRepo repository;

	@Autowired
	DepartmentRepo depRepository;

	@Autowired
	CoursesRepo coursesRepository;

	@Override
	public List<Instructor> getAllInstructors(int page, int size) {

		List<Instructor> instructorList = new ArrayList<>();
		repository.findAll(PageRequest.of(page, size)).forEach(instructorList::add);
		return instructorList;

//		List<Instructor> instructorList = new ArrayList<>();
//		repository.findAll().forEach(instructorList::add);
//		return instructorList;
	}

	@Override
	public Instructor getInstructor(long id) {
		Instructor instructor = repository.findById(id);
		if (instructor == null)
			throw new EntityNotFoundException("No instructor with Id = " + id + "  is found");
		else
			return instructor;
	}

	@Override
	public boolean AddInstructor(Instructor instructor) {
		try {
			repository.save(instructor);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean UpdateInstructor(long id, Instructor instructor) {
		Instructor instructorFromRep = repository.findById(id);
		if (instructorFromRep == null)
			throw new EntityNotFoundException("No instructor with Id = " + id + "  is found");
		else {

			try {
				BeanUtils.copyProperties(instructor, instructorFromRep);
				repository.save(instructorFromRep);
				return true;
			} catch (Exception e) {
				throw e;
			}
		}

	}

	@Override
	public boolean DeleteInstructor(long id) {
		Instructor instructor = repository.findById(id);
		if (instructor == null)
			throw new EntityNotFoundException("No instructor with Id = " + id + "  is found");
		else {
			try {
				repository.DeleteInstructorFromCoursesJoinedTable(id);
			} catch (Exception e) {
			}
			repository.deleteById(id);
			return true;
		}
	}

	@Override
	public boolean AddInstructorToDepartment(long id, long instructorId) {
		Department department = depRepository.findById(id);
		if (department == null)
			throw new EntityNotFoundException("No department with Id = " + id + "  is found");
		else {
			Instructor instructor = repository.findById(instructorId);
			if (instructor == null)
				throw new EntityNotFoundException("No instructors with Id = " + instructorId + "  is found");
			else {

				department.getInstructors().add(instructor);
				depRepository.save(department);
				instructor.setDepartment(department);
				repository.save(instructor);
				return true;
//				instructor.setDepartment(department);
//				repository.save(instructor);
//				department.getInstructors().add(instructor);
//				depRepository.save(department);
//				return true;

			}
		}
	}

	@Override
	public boolean AddInstructorToCourse(long courseId, long instructorId) {
		Courses course = coursesRepository.findById(courseId);
		if (course == null)
			throw new EntityNotFoundException("No Course with Id = " + courseId + "  is found");
		else {
			Instructor instructor = repository.findById(instructorId);
			if (instructor == null)
				throw new EntityNotFoundException("No instructors with Id = " + instructorId + "  is found");
			else {
				try {
					course.getInstructors().add(instructor);
					coursesRepository.save(course);
					return true;

				} catch (Exception e) {
					throw e;
				}

			}
		}
	}

}
