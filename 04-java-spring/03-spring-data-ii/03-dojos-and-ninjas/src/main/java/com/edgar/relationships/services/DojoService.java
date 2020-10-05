package com.edgar.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.relationships.models.Dojo;
import com.edgar.relationships.models.Ninja;
import com.edgar.relationships.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	private DojoRepository dRepo;
	
	//Get all Dojos
	public List<Dojo> getAllDojos() {
		return this.dRepo.findAll();
	}
	
	//Get All Ninjas
	public List<Ninja> getAllNinjas(Dojo dojo) {
		return dojo.getNinjas();
	}
	
	//Get One Dojo
	public Dojo getOneDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	//Create New Dojo
	public Dojo createDojo(Dojo newDojo) {
		return this.dRepo.save(newDojo);
	}
	
	
	
}
