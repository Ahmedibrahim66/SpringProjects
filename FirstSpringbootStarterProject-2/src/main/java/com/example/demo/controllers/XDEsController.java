package com.example.demo.controllers;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.XDE;
import com.example.demo.services.MibServiceImplementation;
import com.example.demo.services.XDEsService;

@RestController
@RequestMapping(value = "/api")
public class XDEsController {
	
	
	@Autowired
	XDEsService xdesService;

	
	
	@PostMapping(value = "/xdes")
	public boolean readXDEs(@RequestBody List<XDE> xdesList){
		return xdesService.saveDataToDataBase(xdesList);
	}
	
	@PostMapping(value = "/job/{uuid}/xdes")
	public boolean addXDEsToJob(@RequestBody List<XDE> xdesList , @PathVariable UUID uuid){
		return xdesService.saveXDEsToJob(xdesList, uuid);
	}
	
	
	
	

}
