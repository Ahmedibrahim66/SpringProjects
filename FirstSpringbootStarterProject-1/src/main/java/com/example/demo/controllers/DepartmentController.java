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

import com.example.demo.models.Department;
import com.example.demo.services.DepartmentServiceImp;

@RestController
@RequestMapping(value = "/api")
public class DepartmentController {
	
	@Autowired
	DepartmentServiceImp departmentService;
	
	
	
	@GetMapping(value= "/departments", params = { "page", "size" })
	public List<Department> getAll(@RequestParam("page") int page, @RequestParam("size") int size,
			UriComponentsBuilder uriBuilder, HttpServletResponse response) {
		return departmentService.getAllDepartments(page, size);
	}
	
	
	@GetMapping(value="/departments/{id}")
	public Department getDepartment(@PathVariable long id) {
		return departmentService.getDepartment(id);
	}
	
	
	@RequestMapping(method=RequestMethod.POST , value= "/departments")
	public Boolean addDepartment(@RequestBody Department department) {
		return departmentService.AddDepartment(department);
	}
	
	@RequestMapping(method = RequestMethod.PUT , value="/departments/{id}")
	public Boolean UpdateDepartment(@RequestBody Department department, @PathVariable long id) {
		return departmentService.UpdateDepartment(id, department);
	}
	
	@RequestMapping(method = RequestMethod.DELETE , value = "/departments/{id}")
	public Boolean DeleteDepartment(@PathVariable long id) {
		return departmentService.DeleteDepartment(id);
	}
	

	

	

}
