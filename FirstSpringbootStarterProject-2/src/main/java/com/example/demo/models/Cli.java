package com.example.demo.models;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Cli {
	
	private String location;
	
	@Column(columnDefinition="TEXT")
	private String command;
	
}
