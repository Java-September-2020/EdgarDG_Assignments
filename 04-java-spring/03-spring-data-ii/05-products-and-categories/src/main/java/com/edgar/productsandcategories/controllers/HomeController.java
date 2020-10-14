package com.edgar.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edgar.productsandcategories.models.Category;
import com.edgar.productsandcategories.models.Product;
import com.edgar.productsandcategories.services.CategoryService;
import com.edgar.productsandcategories.services.ProductService;

@Controller
public class HomeController {
	@Autowired
	private ProductService pService;
	@Autowired
	private CategoryService cService;

	// Products New
	@RequestMapping("/products/new")
	public String newProductForm(@ModelAttribute("product") Product product) {
		return "newProduct.jsp";
	}

	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product newProduct, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/products/new";
		} else {
			this.pService.createProduct(newProduct);
			return "redirect:/products/new";
		}
	}

	// Products View
	@RequestMapping("/products/{id}")
	public String viewProduct(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("product") Product product,
			Model cModel) {
		Product thisProduct = this.pService.findOneProduct(id);
		viewModel.addAttribute("product", thisProduct);
		List<Category> notInProduct = this.cService.categoriesNotInProduct(thisProduct);
		viewModel.addAttribute("notInProduct", notInProduct);
		return "product.jsp";
	}

	// Add Category to Product
	@PostMapping("/products/{id}")
	public String addCategoryToP(@Valid @ModelAttribute("category") Category category, BindingResult result,
			@PathVariable("id") Long id, Model viewModel, @RequestParam("categoryId") Long categoryId) {
		if (result.hasErrors()) {
			Product thisProduct = this.pService.findOneProduct(id);
			viewModel.addAttribute("product", thisProduct);
			List<Category> notInProduct = this.cService.categoriesNotInProduct(thisProduct);
			viewModel.addAttribute("notInProduct", notInProduct);
			return "redirect:/products/{id}";
		} else {
			Product product = pService.findOneProduct(id);
			Category thisCategory = cService.findOneCategory(categoryId);
			this.cService.addCategory(thisCategory, product);
			return "redirect:/products/{id}";
		}
	}

	// Categories New
	@RequestMapping("/categories/new")
	public String newCategoryForm(@ModelAttribute("category") Category category) {
		return "newCategory.jsp";
	}

	@PostMapping("/categories/new")
	public String newCategory(@Valid @ModelAttribute("category") Category newCategory, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/categories/new";
		} else {
			this.cService.createCategory(newCategory);
			return "redirect:/categories/new";
		}
	}

	// Categories View
	@RequestMapping("/categories/{id}")
	public String viewCategory(@PathVariable("id") Long id, Model viewModel) {
		Category thisCategory = this.cService.findOneCategory(id);
		viewModel.addAttribute("category", thisCategory);
		List<Product> notInCategory = this.pService.productsNotInCategory(thisCategory);
		viewModel.addAttribute("notInCategory", notInCategory);
		return "category.jsp";
	}

	@PostMapping("/categories/{id}")
	public String addProductToC(@Valid @ModelAttribute("product") Product product, BindingResult result,
			@PathVariable("id") Long id, Model viewModel, @RequestParam("productId") Long productId) {
		if (result.hasErrors()) {
			Category thisCategory = this.cService.findOneCategory(id);
			viewModel.addAttribute("category", thisCategory);
			List<Product> notInCategory = this.pService.productsNotInCategory(thisCategory);
			viewModel.addAttribute("notInCategory", notInCategory);
			return "category.jsp";
		} else {
			Category category = cService.findOneCategory(id);
			Product thisProduct = pService.findOneProduct(productId);
			this.cService.addCategory(category, thisProduct);
			return "redirect:/categories/{id}";
		}
	}

}
