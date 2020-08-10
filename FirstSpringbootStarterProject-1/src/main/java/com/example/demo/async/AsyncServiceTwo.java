package com.example.demo.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.BacStudent;


@Service
public class AsyncServiceTwo {
	

	@Autowired
	AsyncService asyncSercie;
	
	
	public List<BacStudent> testAsyncAnnotationForMethodsWithReturnType() throws InterruptedException, ExecutionException {
		System.out.println("Invoking an asynchronous method. " + Thread.currentThread().getName());
		Future<List<BacStudent>> future = asyncSercie.asyncMethodWithReturnType();

		while (true) {
			if (future.isDone()) {
				System.out.println("Future is done");

				List<BacStudent> bacStudent = new ArrayList<>();
				System.out.println(future.get());
				future.get().forEach(bacStudent::add);
				return bacStudent;
				
//				System.out.println("Result from asynchronous process - " + future.get());
//				break;
			}
			System.out.println("Continue doing something else. ");
			Thread.sleep(1000);
		}
	}
}
