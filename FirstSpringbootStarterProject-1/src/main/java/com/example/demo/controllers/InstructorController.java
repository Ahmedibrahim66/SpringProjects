package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Instructor;
import com.example.demo.services.InstructorServiceImp;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@RestController
@RequestMapping(value = "/api")
public class InstructorController {
	
	@Autowired
	InstructorServiceImp instructorService;
	
	@GetMapping(value= "/instructors")
	public List<Instructor> getAll() {
		return instructorService.getAllInstructors();
	}
	
	@GetMapping(value="/instructors/{id}")
	public Instructor getCourse(@PathVariable long id) {
		return instructorService.getInstructor(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST , value= "/instructors")
	public Boolean addInstructor(@RequestBody Instructor instructor) {
		return instructorService.AddInstructor(instructor);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT , value="/instructors/{id}")
	public Boolean UpdateInstructor(@RequestBody Instructor instructor, @PathVariable long id) {
		return instructorService.UpdateInstructor(id, instructor);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/instructors/{id}")
	public Boolean DeleteCourse(@PathVariable long id) {
		return instructorService.DeleteInstructor(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST , value = "/departments/{id}/instructors")
	public Boolean AddInstructorToDepartment(@PathVariable long id, @RequestBody Instructor instructor) {
		return instructorService.AddInstructorToDepartment(id, instructor);
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/courses/{courseId}/instructors/{instructorId}")
	public Boolean AddCourseToStudent(@PathVariable long courseId, @PathVariable long instructorId) {
		return instructorService.AddInstructorToCourse(courseId, instructorId);
		
	}
	
	

}
