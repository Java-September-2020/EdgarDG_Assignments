package com.edgar.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.relationships.models.Category;
import com.edgar.relationships.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	//Get All Categories
	public List<Category> getAllCategories() {
		return this.cRepo.findAll();
	}
	
	
	//Create Category
	public Category createCategory(Category newCategory) {
		return this.cRepo.save(newCategory);
	}
	
}
