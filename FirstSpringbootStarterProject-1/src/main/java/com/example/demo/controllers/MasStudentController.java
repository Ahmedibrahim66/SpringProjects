package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.MasStudent;
import com.example.demo.services.MasStudentServiceImp;


@RestController
@RequestMapping(value = "/api")
public class MasStudentController {
	
	@Autowired
	MasStudentServiceImp masStudentService;
	
	
	
	@GetMapping(value="/students/master")
	public List<MasStudent> getAll() {
		return masStudentService.getAllMasStudents();
	}
	
	
	@GetMapping(value="/students/master/{id}")
	public MasStudent getStudent(@PathVariable int id) {
		return masStudentService.getMasStudent(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST , value= "/students/master")
	public Boolean addStudent(@RequestBody MasStudent masStudent) {
		return masStudentService.AddMasStudent(masStudent);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT , value="/students/master/{id}")
	public Boolean UpdateStudent(@RequestBody MasStudent masStudent, @PathVariable int id) {
		return masStudentService.UpdateMasStudent(id, masStudent);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/students/master/{id}")
	public Boolean DeleteStudent(@PathVariable int id) {
		return masStudentService.DeleteMasStudent(id);
	}
	
	@RequestMapping(method = RequestMethod.POST , value = "/courses/{courseId}/students/master/{masStudentId}")
	public Boolean AddCourseToStudent(@PathVariable long courseId, @PathVariable long masStudentId) {
		return masStudentService.AddCourseToStudent(courseId, masStudentId);
		
	}
	
	
	

}
