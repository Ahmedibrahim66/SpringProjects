package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.data.BacStudentRepo;
import com.example.demo.data.CoursesRepo;
import com.example.demo.models.BacStudent;
import com.example.demo.models.Courses;

@Service
public class BacStudentServiceImp implements IBacStudentService {

	@Autowired
	BacStudentRepo repository;

	@Autowired
	CoursesRepo coursesRepository;

	public List<BacStudent> getAllBacStudents(int page, int size) {
		List<BacStudent> studentListPaged = new ArrayList<>();
		repository.findAll(PageRequest.of(page, size)).forEach(studentListPaged::add);
		return studentListPaged;

	}

//	public List<BacStudent> getAllBacStudents() {
//		List<BacStudent> studentList = new ArrayList<>();
//		repository.findAll().forEach(studentList::add);
//		return studentList;
//	}

	public BacStudent getBacStudent(long id) {
		BacStudent student = repository.findById(id);
		if (student == null)
			throw new EntityNotFoundException("No bachelor student with Id = " + id + "  is found");
		else
			return student;
	}

	public boolean UpdateBacStudent(long id, BacStudent bacStudent) {
		BacStudent student = repository.findById(id);
		if (student == null)
			throw new EntityNotFoundException("No bachelor student with Id = " + id + "  is found");
		else {
			try {
				BeanUtils.copyProperties(bacStudent, student);
				repository.save(student);
				return true;
			} catch (Exception e) {
				throw e;
			}
		}
	}

	public boolean DeleteBacStudent(long id) {
		BacStudent student = repository.findById(id);
		if (student == null)
			throw new EntityNotFoundException("No bachelor student with Id = " + id + "  is found");
		else {

			try {
				repository.DeleteBacStudentFromCoursesJoinedTable(id);
			} catch (Exception e) {
			}

			repository.deleteById(id);
			return true;
		}

	}

	public boolean AddBacStudent(BacStudent bacStudent) {
		try {
			repository.save(bacStudent);
			return true;
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public boolean AddCourseToStudent(long courseId, long bacStudentId) {
		Courses course = coursesRepository.findById(courseId);
		if (course == null)
			throw new EntityNotFoundException("No Course with Id = " + courseId + "  is found");
		else {
			BacStudent bacStudent = repository.findById(bacStudentId);

			if (bacStudent == null)
				throw new EntityNotFoundException("No Bachelor Student with Id = " + bacStudentId + "  is found");
			else {
				course.getBacStudents().add(bacStudent);
				coursesRepository.save(course);
				return true;

			}

		}

	}

	@Override
	public List<BacStudent> getCustomQuery(String chars) {
		List<BacStudent> studentList = new ArrayList<>();
		repository.getCustomQuery(chars).forEach(studentList::add);
		return studentList;
	}

	@Override
	public List<BacStudent> getCustomNativeQuery(int size, int page) {
		List<BacStudent> studentList = new ArrayList<>();
		repository.getCustomNativeQuery(PageRequest.of(page, size)).forEach(studentList::add);
		return studentList;
	}

	public double getHighestGPA() {
		return repository.getHighestGPA();
	}

	public int getStudetCount() {
		return repository.getStudetCount();
	}

	public List<BacStudent> getStudentsWithNoCourses() {
		List<BacStudent> studentList = new ArrayList<>();
		repository.getStudentsWithNoCourses().forEach(studentList::add);
		return studentList;
	}

}
