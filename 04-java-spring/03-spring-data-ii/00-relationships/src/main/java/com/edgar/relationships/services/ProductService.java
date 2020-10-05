package com.edgar.relationships.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edgar.relationships.models.Product;
import com.edgar.relationships.repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository pRepo;
	
	//Get all Products
	public List<Product> getAllProducts() {
		return this.pRepo.findAll();
	}
	
	
	//Create Product
	public Product createProduct(Product newProduct) {
		return this.pRepo.save(newProduct);
	}
	
	
}
