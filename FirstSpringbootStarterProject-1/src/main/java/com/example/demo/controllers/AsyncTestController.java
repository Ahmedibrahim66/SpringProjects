package com.example.demo.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.async.AsyncServiceTwo;
import com.example.demo.models.BacStudent;

@RestController
@RequestMapping(value = "/api")
public class AsyncTestController {
	
	@Autowired
	AsyncServiceTwo asyncService;
	
	@GetMapping(value="/async")
	public List<BacStudent> getAddress() throws InterruptedException, ExecutionException {
		System.out.print("testing async function");
		return  asyncService.testAsyncAnnotationForMethodsWithReturnType();
	}
	

}
