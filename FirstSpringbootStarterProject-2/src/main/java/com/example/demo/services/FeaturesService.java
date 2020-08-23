package com.example.demo.services;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.demo.models.Feature;

@Service
public interface FeaturesService {
	
	public boolean saveAllFeatures(List<Feature> featureList);
	public boolean saveFeaturesToJob(List<Feature> featureList  , UUID id);
	
	public List<Feature> findFeaturesByXDE(long id);
	
	public List<Feature> findFeaturesByXdeArtifactId(String artifactId);
	
	public List<Feature> findFeatureByCliCommandLike(String command);
	
	public List<Feature> findFeaturesByMibLike(String mib);
	
	
	
	

}
