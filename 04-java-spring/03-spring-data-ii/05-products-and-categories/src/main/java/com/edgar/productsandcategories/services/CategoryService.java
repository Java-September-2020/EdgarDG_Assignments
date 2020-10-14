package com.edgar.productsandcategories.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.productsandcategories.models.Category;
import com.edgar.productsandcategories.models.Product;
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
	
	//Add Product to Category || Add Category to Product
	public void addCategory(Category category, Product product) {
		//Get List from Products
		List<Product> categorizedProducts = category.getProducts();
		categorizedProducts.add(product);
		this.cRepo.save(category);		
	}
	
	//List of Categories not in Product
	public List<Category> categoriesNotInProduct(Product product) {
		return cRepo.findByProductsNotContaining(product);
	}
	
	
	
}
