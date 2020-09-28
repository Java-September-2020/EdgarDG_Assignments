package com.edgar.languages.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.languages.models.Language;
import com.edgar.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	@Autowired
	private LanguageRepository lRepo;
	
	//Read Language(s)
	//Access All Languages
	public List<Language> getAllLanguages() {
		return this.lRepo.findAll();
	}
	
	//Access One Language
	public Language getOneLanguage(Long id) {
		return this.lRepo.findById(id).orElse(null);
	}
	
	//CRUD
	//Create Language
	public Language createLanguage(Language newLanguage) {
		return this.lRepo.save(newLanguage);
	}
		
	//Update Language
	public Language updateLanguage(Language updatedLanguage) {
		return this.lRepo.save(updatedLanguage);
	}
	
	//Delete Language
	public void deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
	}
	
	
}
