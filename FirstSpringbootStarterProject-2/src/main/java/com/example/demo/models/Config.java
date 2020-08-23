package com.example.demo.models;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

import lombok.Data;

@Data
@Embeddable
public class Config {
	
	private String property;
	
	@Embedded
	private Params params;
	
	private String value;
	
}
