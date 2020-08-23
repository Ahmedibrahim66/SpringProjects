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
import com.example.demo.models.Profile;
import com.example.demo.services.ProfilesService;

@RestController
@RequestMapping(value = "/api")
public class ProfilesController {
	
	@Autowired
	ProfilesService profileService;
	
	@PostMapping(value = "/profiles")
	public boolean readProfiles(@RequestBody List<Profile> profileList){
		return profileService.saveAllProfiles(profileList);
	}
	
	@PostMapping(value = "/job/{uuid}/profiles")
	public boolean addProfilesToJob(@RequestBody List<Profile> profileList , @PathVariable UUID uuid){
		return profileService.saveProfileToJob(profileList, uuid);
		
	}
	
	@GetMapping(value = "/profile/xdes/{id}")
	public List<Profile> getProfileFromXDE(@PathVariable long id) {
		return profileService.getProfileFromXDE(id);
	}
	
	
	@GetMapping(value = "/profile/features/xdes/cli/{command}")
	public List<Profile> getProfilesFromCliCommandLike(@PathVariable String command) {
		return profileService.getProfilesFromCliCommandLike(command);
	}
	
	
	
	

}
