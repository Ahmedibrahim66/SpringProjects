package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.data.DepartmentRepo;
import com.example.demo.models.Department;

@Service
public class DepartmentServiceImp implements IDepartmentService {

	@Autowired
	DepartmentRepo repository;

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departmentList = new ArrayList<>();
		repository.findAll().forEach(departmentList::add);
		return departmentList;
	}

	@Override
	public Department getDepartment(long id) {
		Department department = repository.findById(id);
		if (department == null)
			throw new EntityNotFoundException("No department with Id = " + id + "  is found");
		else
			return department;
	}

	@Override
	public boolean AddDepartment(Department department) {
		
		try {
			repository.save(department);
			return true;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean UpdateDepartment(long id, Department department) {
		Department departmentFromRepo = repository.findById(id);
		if (departmentFromRepo == null)
			throw new EntityNotFoundException("No department with Id = " + id + "  is found");
		else {
			try {
				BeanUtils.copyProperties(department, departmentFromRepo);
				repository.save(departmentFromRepo);
				return true;
			} catch (Exception e) {
				throw e;
			}
		}
	}

	@Override
	public boolean DeleteDepartment(long id) {
		Department department = repository.findById(id);
		if (department == null)
			throw new EntityNotFoundException("No department with Id = " + id + "  is found");
		else {
			repository.deleteById(id);
			return true;
		}

	}

}
