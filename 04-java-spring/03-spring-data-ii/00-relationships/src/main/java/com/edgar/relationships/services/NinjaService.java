package com.edgar.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.relationships.models.Ninja;
import com.edgar.relationships.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository nRepo;
	
	//Get All Ninjas
	public List<Ninja> getAllNinjas() {
		return this.nRepo.findAll();
	}
	
	
	//Create a Ninja
	public Ninja createNinja(Ninja newNinja) {
		return this.nRepo.save(newNinja);
	}
	
	
	
}
