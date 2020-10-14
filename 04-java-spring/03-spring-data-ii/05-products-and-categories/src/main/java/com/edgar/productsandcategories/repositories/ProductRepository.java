package com.edgar.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edgar.productsandcategories.models.Category;
import com.edgar.productsandcategories.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	
	//Find List of Product that do NOT belong to category
	List<Product> findByCategoriesNotContaining(Category category);
}
