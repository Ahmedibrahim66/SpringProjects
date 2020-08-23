package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.MibService;
import com.example.demo.services.MibServiceImplementation;

@RestController
@RequestMapping(value = "/api")
public class MibController {
	
	
	@Autowired
	MibService service;
	
	@GetMapping(value = "/xdes/mib/{id}")
	public List<String> getXDEMib(@PathVariable long id){
		return service.getXDEmib(id);
		
	}
	

}
