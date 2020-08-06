 package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.data.CoursesRepo;
import com.example.demo.data.MasStudentRepo;
import com.example.demo.models.Courses;
import com.example.demo.models.MasStudent;

@Service
public class MasStudentServiceImp implements IMasStudentService {

	@Autowired
	MasStudentRepo repository;

	@Autowired
	CoursesRepo coursesRepository;
	
	@Override
	public List<MasStudent> getAllMasStudents(int page, int size) {
		
		List<MasStudent> studentList = new ArrayList<>();
		repository.findAll(PageRequest.of(page, size)).forEach(studentList::add);
		return studentList;
		
		
//		List<MasStudent> studentList = new ArrayList<>();
//		repository.findAll().forEach(studentList::add);
//		return studentList;
	}

	@Override
	public MasStudent getMasStudent(long id) {
		MasStudent student = repository.findById(id);
		if (student == null)
			throw new EntityNotFoundException("No master student with Id = " + id + "  is found");
		else
			return student;
	}

	@Override
	public boolean AddMasStudent(MasStudent masStudent) {
		try {
			repository.save(masStudent);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean UpdateMasStudent(long id, MasStudent masStudent) {

		MasStudent student = repository.findById(id);
		if (student == null)
			throw new EntityNotFoundException("No master Student with Id = " + id + "  is found");
		else {
			try {
				BeanUtils.copyProperties(masStudent, student);
				repository.save(student);
				return true;
			} catch (Exception e) {
				throw e;
			}
		}

	}

	@Override
	public boolean DeleteMasStudent(long id) {
		MasStudent student = repository.findById(id);
		if (student == null)
			throw new EntityNotFoundException("No master Student with Id = " + id + "  is found");
		else {
			repository.deleteById(id);
			return true;
		}
	}

	@Override
	public boolean AddCourseToStudent(long courseId, long masStudentId) {
		Courses course = coursesRepository.findById(courseId);
		if (course == null)
			throw new EntityNotFoundException("No Course with Id = " + courseId + "  is found");
		else {
			MasStudent masStudent = repository.findById(masStudentId);

			if (masStudent == null)
				throw new EntityNotFoundException("No master Student with Id = " + masStudentId + "  is found");
			else {
				course.getMasStudents().add(masStudent);
				coursesRepository.save(course);
				return true;

			}

		}
	}

}
