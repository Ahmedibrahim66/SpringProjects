package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.models.Cli;
import com.example.demo.models.XDE;

@Service
public interface XDEsService {
	
	public boolean saveDataToDataBase(List<XDE> xdesList );
	public boolean saveXDEsToJob(List<XDE> xdesList  , UUID id);
	

}
