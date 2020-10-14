package com.edgar.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edgar.productsandcategories.models.Category;
import com.edgar.productsandcategories.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	
	//Find List of Categories that do NOT belong to product
	List<Category> findByProductsNotContaining(Product product);
	
	
}


