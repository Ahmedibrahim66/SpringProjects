package com.example.demo.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "BacStudents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BacStudent {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private double gpa;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false)
	private String collage;
	
	@Column(nullable = false)
	private int startYear;
	
	
	@ManyToMany(mappedBy = "bacStudents")
	@JsonIgnoreProperties({"phdStudents" , "department", "masStudents" , "bacStudents"})
	private List<Courses> courses = new ArrayList<Courses>();
	
	
		

}
