package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Courses")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Courses {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column
	private String name;
//	
//	@Column
//	private String department;
//	
	@Column
	private int hours;
	
	@ManyToOne()
	@JoinColumn(name="departmentId")
	@JsonIgnoreProperties({"courses" , "instructors" , "address"})
	private Department department;
	
	
	@ManyToMany()
	@JoinTable(name = "bacStudent_course", joinColumns=@JoinColumn(name="bacStudent_id"),
	inverseJoinColumns=@JoinColumn(name="course_id"))
	@JsonIgnoreProperties({"courses"})
	//@JsonIgnore
	private List<BacStudent> bacStudents = new ArrayList<BacStudent>();
	
	
	@ManyToMany()
	@JoinTable(name = "masStudent_course", joinColumns=@JoinColumn(name="masStudent_id"),
	inverseJoinColumns=@JoinColumn(name="course_id"))
	@JsonIgnoreProperties({"courses"})
	private List<MasStudent> MasStudents = new ArrayList<MasStudent>();
	
	@ManyToMany()
	@JoinTable(name = "PhdStudent_course", joinColumns=@JoinColumn(name="phdStudent_id"),
	inverseJoinColumns=@JoinColumn(name="course_id"))
	@JsonIgnoreProperties({"courses"})
	private List<PHDStudent> PhdStudents = new ArrayList<PHDStudent>();
	

	@ManyToMany()
	@JoinTable(name = "Instructors_course", joinColumns=@JoinColumn(name="Instructor_id"),
	inverseJoinColumns=@JoinColumn(name="course_id"))
	@JsonIgnoreProperties({"courses"})
	private List<Instructor> instructors = new ArrayList<Instructor>();
	
	
	
	
}
