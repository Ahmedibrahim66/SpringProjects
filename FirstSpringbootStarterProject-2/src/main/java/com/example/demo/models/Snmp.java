package com.example.demo.models;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Snmp {

	private String location;
	
	private String mib;
	
}
