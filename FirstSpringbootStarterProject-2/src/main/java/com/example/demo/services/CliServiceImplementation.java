package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.XDEsRepository;
import com.example.demo.models.Cli;


@Service
public class CliServiceImplementation  implements CliService{

	
	@Autowired
	XDEsRepository xdeRepo;
	
	@Override
	public List<Cli> getXDECli(long id) {
		return 	xdeRepo.findById(id).getCliList();
		
	}
	
	

}
