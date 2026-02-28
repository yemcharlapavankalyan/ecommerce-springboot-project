package com.ecommerce.project.service;

import java.util.List;

import com.ecommerce.project.controller.model.Category;

// interface promotes loosely coupling and modularity
public interface CategoryService {

	List<Category> getAllCategories();
	void createCategory(Category category);
	public String deleteCategory(Long categoryId);
	Category updateCategory(Category category, Long categoryId);
 }
