package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.data.FeaturesRepository;
import com.example.demo.data.JobsRepository;
import com.example.demo.data.ProfilesRepository;
import com.example.demo.models.Feature;
import com.example.demo.models.Job;
import com.example.demo.models.Profile;

@Service
public class ProfilesServiceImplementation implements ProfilesService {

	@Autowired
	ProfilesRepository repository;

	@Autowired
	FeaturesRepository featureRepo;

	@Autowired
	JobsRepository jobsRepo;

	@Override
	public boolean saveAllProfiles(List<Profile> profileList) {

		List<String> artifcatId = new ArrayList<>();
		List<String> groupId = new ArrayList<>();
		List<Feature> featuresList = new ArrayList<>();

		profileList.forEach(x -> {
			artifcatId.clear();
			groupId.clear();
			featuresList.clear();

			if (x.getFeatureList().size() >= 1) {
				x.getFeatureList().forEach(y -> {
					artifcatId.add(0, y.getArtifactId());
					groupId.add(0, y.getGroupId());
					featureRepo.getProfileFeature(artifcatId.get(0), groupId.get(0)).forEach(k -> {
						featuresList.add(k);
					});
				});

				featuresList.forEach(j -> {
					x.getFeatureRealtion().add(j);
				});

			}

			repository.save(x);

		});

		return true;

	}

	@Override
	public boolean saveProfileToJob(List<Profile> profileList, UUID id) {
		Job job = jobsRepo.getFromId(id);
		if (job == null)
			throw new EntityNotFoundException("No job found");
		else {
			try {
				List<String> artifcatId = new ArrayList<>();
				List<String> groupId = new ArrayList<>();
				List<Feature> featuresList = new ArrayList<>();

				profileList.forEach(x -> {
					artifcatId.clear();
					groupId.clear();
					featuresList.clear();

					if (x.getFeatureList().size() >= 1) {
						x.getFeatureList().forEach(y -> {
							artifcatId.add(0, y.getArtifactId());
							groupId.add(0, y.getGroupId());
							featureRepo.getProfileFeature(artifcatId.get(0), groupId.get(0)).forEach(k -> {
								featuresList.add(k);
							});
						});

						featuresList.forEach(j -> {
							x.getFeatureRealtion().add(j);
						});

					}

					job.getProfileList().add(x);
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
	public List<Profile> getProfileFromXDE(long id) {
		List<Profile> profileList = new ArrayList<>();
		repository.getProfileFromXDE(id).forEach(profileList::add);
		return profileList ;
	}

	@Override
	public List<Profile> getProfilesFromCliCommandLike(String command) {
		List<Profile> profileList = new ArrayList<>();
		repository.getProfileFromCliCommandLike(command).forEach(profileList::add);
		return profileList ;
	}

}
