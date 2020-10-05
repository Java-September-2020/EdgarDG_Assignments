package com.edgar.relationships.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.relationships.models.License;
import com.edgar.relationships.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository lRepo;
	
	//Get One License
	public License getOneLicense(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	//Create a License
	public License createNewLicense(License newLicense) {
		return this.lRepo.save(newLicense);
	}
	
	
	
}	
