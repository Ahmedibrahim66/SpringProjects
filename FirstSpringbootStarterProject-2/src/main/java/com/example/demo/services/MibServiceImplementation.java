package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.XDEsRepository;

@Service
public class MibServiceImplementation implements MibService{

	@Autowired
	XDEsRepository xdeRepo;
	
	
	@Override
	public List<String> getXDEmib(long id) {
		
		return xdeRepo.getXDEMib(id);
		
	}

}
