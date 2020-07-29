package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Courses;
import com.example.demo.models.Instructor;
import com.example.demo.services.CoursesServiceImp;

@RestController
@RequestMapping(value = "/api")
public class CoursesController {

	@Autowired
	CoursesServiceImp coursesService;
	
	
	
	@GetMapping(value= "/courses")
	public List<Courses> getAll() {
		return coursesService.getAllCourses();
	}
	
	
	@GetMapping(value="/courses/{id}")
	public Courses getCourse(@PathVariable long id) {
		return coursesService.getCourse(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST , value= "/courses")
	public Boolean addCourse(@RequestBody Courses course) {
		return coursesService.AddCourse(course);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT , value="/courses/{id}")
	public Boolean UpdateCourse(@RequestBody Courses course, @PathVariable long id) {
		return coursesService.UpdateCourse(id, course);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/courses/{id}")
	public Boolean DeleteCourse(@PathVariable long id) {
		return coursesService.DeleteCourse(id);
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/departments/{id}/courses")
	public Boolean AddInstructorToDepartment(@PathVariable long id, @RequestBody Courses course) {
		return coursesService.AddCourseToDepartment(id, course);
	}
	
	
	

	
}
