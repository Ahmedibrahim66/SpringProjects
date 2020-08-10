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

import com.example.demo.models.Instructor;
import com.example.demo.services.IInstructorService;


@RestController
@RequestMapping(value = "/api")
public class InstructorController {
	
	@Autowired
	IInstructorService instructorService;
	
	@GetMapping(value= "/instructors" ,params = { "page", "size" })
	public List<Instructor> getAll(@RequestParam("page") int page, @RequestParam("size") int size,
			UriComponentsBuilder uriBuilder, HttpServletResponse response) {
		return instructorService.getAllInstructors(page, size);
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
	
	
	@RequestMapping(method = RequestMethod.POST , value = "/departments/{id}/instructors/{instructorId}")
	public Boolean AddInstructorToDepartment(@PathVariable long id, @PathVariable long instructorId) {
		return instructorService.AddInstructorToDepartment(id,  instructorId);
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/courses/{courseId}/instructors/{instructorId}")
	public Boolean AddInstructorToCourse(@PathVariable long courseId, @PathVariable long instructorId) {
		return instructorService.AddInstructorToCourse(courseId, instructorId);
		
	}
	
	

}
