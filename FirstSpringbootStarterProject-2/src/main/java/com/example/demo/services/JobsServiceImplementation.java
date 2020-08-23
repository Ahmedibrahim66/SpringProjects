package com.example.demo.services;



import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.JobsRepository;
import com.example.demo.models.Job;


@Service
public class JobsServiceImplementation implements JobsService {

	@Autowired
	JobsRepository repository;
	
	@Override
	public boolean createJob(Job job) {
		job.setTime(Timestamp.valueOf(LocalDateTime.now()));
		repository.save(job);
		return true;
	}
	

}
