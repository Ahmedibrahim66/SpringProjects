package com.example.demo.models;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Params {
	
	private String k;
	private String v;
	
}
