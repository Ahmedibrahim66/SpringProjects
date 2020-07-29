package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.PHDStudent;
import com.example.demo.services.PhdStudentServiceImp;


@RestController
@RequestMapping(value = "/api")
public class PhdStudentController {
	
	@Autowired
	PhdStudentServiceImp phdStudentService;
	
	
	
	@GetMapping(value="/students/phd")
	public List<PHDStudent> getAll() {
		return phdStudentService.getAllPhdStudents();
	}
	
	
	@GetMapping(value="/students/phd/{id}")
	public PHDStudent getStudent(@PathVariable long id) {
		return phdStudentService.getPhdStudent(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST , value= "/students/phd")
	public Boolean addStudent(@RequestBody PHDStudent phdStudent) {
		return phdStudentService.AddPhdStudent(phdStudent);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT , value="/students/phd/{id}")
	public Boolean UpdateStudent(@RequestBody PHDStudent phdStudent, @PathVariable int id) {
		return phdStudentService.UpdatePhdStudent(id, phdStudent);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/students/phd/{id}")
	public Boolean DeleteStudent(@PathVariable int id) {
		return phdStudentService.DeletePhdStudent(id);
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/courses/{courseId}/students/phd/{phdStudentId}")
	public Boolean AddCourseToStudent(@PathVariable long courseId, @PathVariable long phdStudentId) {
		return phdStudentService.AddCourseToStudent(courseId, phdStudentId);
		
	}
	
	

}
