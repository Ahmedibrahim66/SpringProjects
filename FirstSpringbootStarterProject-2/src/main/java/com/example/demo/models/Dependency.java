package com.example.demo.models;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Dependency {
	
	private String groupId;
	private String artifactId;
	private String version;
	private String type;

}
