package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.models.BacStudent;
import com.example.demo.services.BacStudentServiceImp;

@RestController
@RequestMapping(value = "/api")
public class BacStudentController {

	@Autowired
	BacStudentServiceImp bacStudentService;

//	@GetMapping(value = "/students/bachelor")
//	public List<BacStudent> getAll() {
//		return bacStudentService.getAllBacStudents();
//	}

	@GetMapping(params = { "page", "size" }, value = "/students/bachelor")
	public List<BacStudent> findAll(@RequestParam("page") int page, @RequestParam("size") int size,
			UriComponentsBuilder uriBuilder, HttpServletResponse response) {
		return bacStudentService.getAllBacStudents(page, size);
	}

	@GetMapping(value = "/students/bachelor/{id}")
	public BacStudent getStudent(@PathVariable long id) {
		return bacStudentService.getBacStudent(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/students/bachelor")
	public Boolean addStudent(@RequestBody BacStudent bacStudent) {
		return bacStudentService.AddBacStudent(bacStudent);

	}

	@RequestMapping(method = RequestMethod.PUT, value = "/students/bachelor/{id}")
	public Boolean UpdateStudent(@RequestBody BacStudent bacStudent, @PathVariable long id) {
		return bacStudentService.UpdateBacStudent(id, bacStudent);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/students/bachelor/{id}")
	public Boolean DeleteStudent(@PathVariable long id) {
		return bacStudentService.DeleteBacStudent(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/courses/{courseId}/students/bachelor/{bacStudentId}")
	public Boolean AddCourseToStudent(@PathVariable long courseId, @PathVariable long bacStudentId) {
		return bacStudentService.AddCourseToStudent(courseId, bacStudentId);

	}

	@GetMapping(value = "/students/bachelor/query/{chars}")
	public List<BacStudent> getCustomQuery(@PathVariable String chars) {
		return bacStudentService.getCustomQuery(chars);
	}
	
	@GetMapping(value = "/students/bachelor/nativequery")
	public List<BacStudent> getCustomNativeQuery() {
		return bacStudentService.getCustomNativeQuery();
	}
	
	
	@GetMapping(value = "/students/bachelor/gpa")
	public double getHighestGPA() {
		return bacStudentService.getHighestGPA();
	}
	
	@GetMapping(value = "/students/bachelor/count")
	public int getStudetCount() {
		return bacStudentService.getStudetCount();
	}
	
	
	@GetMapping(value = "/students/bachelor/noCourse")
	public List<BacStudent> getStudentWithNoCourses() {
		return bacStudentService.getStudentsWithNoCourses();
	}
	
	
	
	
	
	
	
	

}
