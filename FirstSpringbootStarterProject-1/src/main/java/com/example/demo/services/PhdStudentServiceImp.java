package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.data.CoursesRepo;
import com.example.demo.data.PhdStudentRepo;
import com.example.demo.models.Courses;
import com.example.demo.models.PHDStudent;

@Service
public class PhdStudentServiceImp implements IPhdStudentService {

	@Autowired
	PhdStudentRepo repository;
	
	@Autowired 
	CoursesRepo coursesRepository;

	@Override
	public List<PHDStudent> getAllPhdStudents(int page, int size) {
		List<PHDStudent> studentList = new ArrayList<>();
		repository.findAll(PageRequest.of(page, size)).forEach(studentList::add);
		return studentList;
		
//		List<PHDStudent> studentList = new ArrayList<>();
//		repository.findAll().forEach(studentList::add);
//		return studentList;
	}

	@Override
	public PHDStudent getPhdStudent(long id) {
		PHDStudent student = repository.findById(id);
		if (student == null)
			throw new EntityNotFoundException("No PHD student with Id = " + id + "  is found");
		else
			return student;
	}

	@Override
	public boolean AddPhdStudent(PHDStudent phdStudent) {
		try {
			repository.save(phdStudent);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean UpdatePhdStudent(long id, PHDStudent phdStudent) {
		PHDStudent student = repository.findById(id);
		if (student == null)
			throw new EntityNotFoundException("No PHD Student with Id = " + id + "  is found");
		else {
			try {
				BeanUtils.copyProperties(phdStudent, student);
				repository.save(student);
				return true;
			} catch (Exception e) {
				throw e;
			}
		}

	}

	@Override
	public boolean DeletePhdStudent(long id) {

		PHDStudent student = repository.findById(id);
		if (student == null)
			throw new EntityNotFoundException("No PHD Student with Id = " + id + "  is found");
		else {
			repository.deleteById(id);
			return true;
		}

	}

	@Override
	public boolean AddCourseToStudent(long courseId, long phdStudentId) {
		Courses course = coursesRepository.findById(courseId);
		if (course == null)
			throw new EntityNotFoundException("No Course with Id = " + courseId + "  is found");
		else {
			PHDStudent phdStudent = repository.findById(phdStudentId);
			if (phdStudent == null)
				throw new EntityNotFoundException("No PHD Student with Id = " + phdStudentId + "  is found");
			else {
				course.getPhdStudents().add(phdStudent);
				coursesRepository.save(course);
				return true;
			}

		}
	}

}
