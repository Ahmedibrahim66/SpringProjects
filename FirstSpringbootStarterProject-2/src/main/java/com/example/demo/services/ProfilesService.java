package com.example.demo.services;

import java.util.List;
import java.util.UUID;
import com.example.demo.models.Profile;

public interface ProfilesService {
	
	public boolean saveAllProfiles(List<Profile> profileList);
	public boolean saveProfileToJob(List<Profile> profileList  , UUID id);
	public List<Profile> getProfileFromXDE(long id);
	public List<Profile> getProfilesFromCliCommandLike(String command);
	

}
