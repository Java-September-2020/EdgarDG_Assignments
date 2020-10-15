package com.edgar.dojooverflow.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.dojooverflow.models.Tag;
import com.edgar.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;

	public Tag createTag(Tag newTag) {
		Tag tag = this.tRepo.save(newTag);
		return tag;
	}

}
