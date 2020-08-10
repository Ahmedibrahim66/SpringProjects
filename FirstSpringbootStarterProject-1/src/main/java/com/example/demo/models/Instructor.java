package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Instructors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Instructor {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column
	private String name;
	
//	@Column
//	private String department;
	
	@Column
	private String gradLevel;
	
	@Column
	private String collageName;
	
	@ManyToOne()
	@JoinColumn(name="departmentId")
	@JsonIgnoreProperties({"instructors" , "courses" , "address"})
	private Department department;
	
	
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "Instructors_course", joinColumns=@JoinColumn(name="Instructor_id"),
//	inverseJoinColumns=@JoinColumn(name="course_id"))
//	@JsonIgnoreProperties({"phdStudents" , "department", "masStudents" , "bacStudents"})
//	private List<Courses> courses = new ArrayList<Courses>();
//	
	
	@ManyToMany(mappedBy = "instructors")
	@JsonIgnoreProperties({"phdStudents" , "department", "masStudents" , "bacStudents"})
	private List<Courses> courses = new ArrayList<Courses>();
	
	
	
	

}
