package com.example.demo.models;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private long id;
	
	
	@Column(nullable = false)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressId" , referencedColumnName="id")
	@JsonIgnoreProperties({"department"})
	private Address address;
	
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "department", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"department"})
	private List<Instructor> instructors = new ArrayList<Instructor>();
	
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "department", fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"department"})
	private List<Courses> courses = new ArrayList<Courses>();
	
	
}
