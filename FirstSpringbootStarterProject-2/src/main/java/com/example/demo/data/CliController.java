package com.example.demo.data;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Cli;
import com.example.demo.services.CliService;

@RestController
@RequestMapping(value = "/api")
public class CliController {

	@Autowired
	CliService service;
	
	@GetMapping(value = "/xdes/cli/{id}")
	public List<Cli> addXDEsToJob(@PathVariable long id){
		return service.getXDECli(id);
	}
	
}
