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

import com.example.demo.models.Feature;
import com.example.demo.services.FeaturesService;

@RestController
@RequestMapping(value = "/api")
public class FeatureController {

	@Autowired
	FeaturesService featureService;

	@PostMapping(value = "/features")
	public boolean readXDEs(@RequestBody List<Feature> featureList) {

		return featureService.saveAllFeatures(featureList);

	}
	
	@PostMapping(value = "/job/{uuid}/features")
	public boolean addFeaturessToJob(@RequestBody List<Feature> featuresList , @PathVariable UUID uuid){
		return featureService.saveFeaturesToJob(featuresList,uuid);
	}
	
	@GetMapping(value = "/feature/xdes/{id}")
	public List<Feature> findFeatureByXDE(@PathVariable long id) {
		
		return featureService.findFeaturesByXDE(id);
		
	}
	
	@GetMapping(value = "/feature/xdes/artifactid/{artifactId}")
	public List<Feature> findFeatureByXdeArtifactId(@PathVariable String artifactId){
		
		return featureService.findFeaturesByXdeArtifactId(artifactId);
		
		
	}
	
	@GetMapping(value = "/feature/xdes/cli/command/{command}")
	public List<Feature> findFeatureByCliCommandLike(@PathVariable String command){
		return featureService.findFeatureByCliCommandLike(command);
	}
	
	
	@GetMapping(value = "/feature/xdes/snmp/mib/{miblike}")
	public List<Feature> findFeatureBySnmpMibLike(@PathVariable String miblike){
		System.out.println(miblike);
		return featureService.findFeaturesByMibLike(miblike);
	}
	
	

}
