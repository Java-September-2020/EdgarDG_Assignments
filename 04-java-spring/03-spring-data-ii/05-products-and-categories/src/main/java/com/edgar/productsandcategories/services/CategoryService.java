package com.edgar.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.productsandcategories.models.Category;
import com.edgar.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository cRepo;
	
	//Create a Category
	public Category createCategory(Category newCategory) {
		Category category = this.cRepo.save(newCategory);
		return category;
	}
	
	//Get all categories
	public List<Category> findAllCategories() {
		List<Category> categoriesList = this.cRepo.findAll();
		return categoriesList;
	}
	
	//Get one category
	public Category findOneCategory(Long id) {
		Category category = this.cRepo.findById(id).orElse(null);
		return category;
	}	
	
}
