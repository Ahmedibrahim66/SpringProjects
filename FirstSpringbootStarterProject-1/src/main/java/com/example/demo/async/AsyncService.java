package com.example.demo.async;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import com.example.demo.data.BacStudentRepo;
import com.example.demo.models.BacStudent;

@Service
public class AsyncService {
	
	@Autowired
	BacStudentRepo repo;
	
	
	@Async
	public void asyncMethodWithVoidReturnType() {
	    System.out.println("Execute method asynchronously. " 
	      + Thread.currentThread().getName());
	}

	@Async
	public Future<List<BacStudent>> asyncMethodWithReturnType() {
	    System.out.println("Execute method asynchronously - " 
	      + Thread.currentThread().getName());
	    try {
	        Thread.sleep(5000);
	        return new AsyncResult<List<BacStudent>>(repo.findAll());
//	        return new AsyncResult<String>("hello world !!!!");
	    } catch (InterruptedException e) {
	        //
	    }
	 
	    return CompletableFuture.completedFuture(null);
	}
	
}
