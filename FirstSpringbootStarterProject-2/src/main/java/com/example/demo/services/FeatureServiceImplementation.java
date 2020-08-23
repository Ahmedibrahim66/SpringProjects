package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.FeaturesRepository;
import com.example.demo.data.JobsRepository;
import com.example.demo.data.XDEsRepository;
import com.example.demo.models.Feature;
import com.example.demo.models.Job;
import com.example.demo.models.XDE;

@Service
public class FeatureServiceImplementation implements FeaturesService {

	@Autowired
	FeaturesRepository repository;

	@Autowired
	XDEsRepository xdeRepo;

	@Autowired
	JobsRepository jobsRepo;

	@Override
	public boolean saveAllFeatures(List<Feature> featureList) {

		List<String> artifcatId = new ArrayList<>();
		List<String> groupId = new ArrayList<>();
		List<XDE> xdesList = new ArrayList<>();
		featureList.forEach(x -> {
			artifcatId.clear();
			groupId.clear();
			xdesList.clear();

			if (x.getXdeList().size() >= 1) {
				x.getXdeList().forEach(y -> {
					artifcatId.add(0, y.getArtifactId());
					groupId.add(0, y.getGroupId());
					xdeRepo.getFeatureXDE(artifcatId.get(0), groupId.get(0)).forEach(k -> {
						xdesList.add(k);
					});
				});

				xdesList.forEach(j -> {
					x.getXdesRealtion().add(j);
				});

			}

			repository.save(x);

		});

		return true;
	}

	@Override
	public boolean saveFeaturesToJob(List<Feature> featureList, UUID id) {
		Job job = jobsRepo.getFromId(id);
		if (job == null)
			throw new EntityNotFoundException("No job found");
		else {
			try {
				List<String> artifcatId = new ArrayList<>();
				List<String> groupId = new ArrayList<>();
				List<XDE> xdesList = new ArrayList<>();
				featureList.forEach(x -> {
					artifcatId.clear();
					groupId.clear();
					xdesList.clear();

					if (x.getXdeList().size() >= 1) {
						x.getXdeList().forEach(y -> {
							artifcatId.add(0, y.getArtifactId());
							groupId.add(0, y.getGroupId());
							xdeRepo.getFeatureXDE(artifcatId.get(0), groupId.get(0)).forEach(k -> {
								xdesList.add(k);
							});
						});

						xdesList.forEach(j -> {
							x.getXdesRealtion().add(j);
						});

					}

					job.getFeaturesList().add(x);
					x.setJob(job);
					repository.save(x);

				});

				return true;

			} catch (Exception e) {
				return false;

			}

		}
	}

	@Override
	public List<Feature> findFeaturesByXDE(long id) {
		List<Feature> featureList = new ArrayList<>();
		repository.getFeatureFromXDE(id).forEach(featureList::add);
		return featureList;
		
	}

	@Override
	public List<Feature> findFeaturesByXdeArtifactId(String artifactId) {
		List<Feature> featureList = new ArrayList<>();
		repository.getFeaturesFromXdeArtifactId(artifactId).forEach(featureList::add);
		return featureList;
		
		
		
	}

	@Override
	public List<Feature> findFeatureByCliCommandLike(String command) {
		List<Feature> featureList = new ArrayList<>();
		repository.getFeaturesFromCliCommnadLike(command).forEach(featureList::add);
		return featureList;
	}

	@Override
	public List<Feature> findFeaturesByMibLike(String mib) {
		List<Feature> featureList = new ArrayList<>();
		repository.getFeaturesFromSnmpMibLike(mib).forEach(featureList::add);
		return featureList;
	}

	 
}
