package com.edgar.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.dojooverflow.models.Tag;
import com.edgar.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;

	//Find Tag By Name
	public Tag findByName(String name) {
		Tag tag = this.tRepo.findByTagIs(name);
		return tag;
	}
	
	// Find One Tag
	public Tag findOneTag(Long id) {
		Tag tag = this.tRepo.findById(id).orElse(null);
		return tag;
	}

	// Create Tag
	public Tag createTag(Tag newTag) {
		Tag tag = this.tRepo.save(newTag);
		return tag;
	}

	// Overloaded Create Tag for Validations
	public Tag createTag(String tag) {
		Tag newTag = new Tag(tag);
		Tag validTag = this.tRepo.save(newTag);
		return validTag;
	}

}
