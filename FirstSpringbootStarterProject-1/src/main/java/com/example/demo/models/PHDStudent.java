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
@Table(name = "PHDStudents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PHDStudent {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private double gpa;
	
	@Column
	private double bacGPA;
	
	@Column
	private double masGPA;
	
	@Column
	private String city;
	
	@Column
	private String collage;
	
	@Column
	private int startYear;
	
	
	@ManyToMany( cascade= CascadeType.ALL ,mappedBy = "PhdStudents")
	@JsonIgnoreProperties({"phdStudents" , "department", "masStudents" , "bacStudents"})
	private List<Courses> courses = new ArrayList<Courses>();
	
	
}
