package com.example.demo.services;

import java.util.List;
import com.example.demo.models.Department;

public interface IDepartmentService {
	
	public List<Department> getAllDepartments();
	public Department getDepartment(long id);
	public boolean AddDepartment(Department department);
	public boolean UpdateDepartment(long id , Department department);
	public boolean DeleteDepartment(long id);

}
