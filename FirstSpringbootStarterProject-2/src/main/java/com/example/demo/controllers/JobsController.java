package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Job;
import com.example.demo.services.JobsService;

@RestController
@RequestMapping(value = "/api")
public class JobsController {
	
	@Autowired
	JobsService service;
	
	@PostMapping(value = "/jobs")
	public boolean createJob(@RequestBody Job job){
		return service.createJob(job);	
	}
	

	
	
	

}
