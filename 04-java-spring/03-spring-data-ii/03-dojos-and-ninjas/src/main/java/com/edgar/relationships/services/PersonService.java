package com.edgar.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.relationships.models.Person;
import com.edgar.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository pRepo;
	
	//Get all Persons
	public List<Person> getAllPersons() {
		return this.pRepo.findAll();
	}
	
	//Get One Person
	public Person getOnePerson(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	//Create a Person
	public Person createPerson(Person newPerson) {
		return this.pRepo.save(newPerson);
	}
	
	
}
