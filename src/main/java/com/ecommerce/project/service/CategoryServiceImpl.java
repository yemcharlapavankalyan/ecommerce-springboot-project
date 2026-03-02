package com.ecommerce.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.controller.model.Category;
import com.ecommerce.project.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	private List<Category> categories = new ArrayList<>();
	private Long nextId = 1L;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	
	@Override
	public List<Category> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	@Override
	public void createCategory(Category category) {
		category.setCategoryId(nextId++);
		categoryRepository.save(category);
	
	}
	
	@Override
	public String deleteCategory(Long categoryId) {
		
		Category category = categoryRepository.findById(categoryId)
							.orElseThrow(() -> new ResponseStatusException(HttpStatus.
									NOT_FOUND,"Category not found with id: "+ categoryId));
		
		categoryRepository.delete(category);
		return "Category with categoryId: "+ categoryId + " deleted Sucessfully";
		
	}
	
	
	@Override
	public Category updateCategory(Category category, Long categoryId) {

		Category savedCategory = categoryRepository.findById(categoryId).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Resource Not Found"));
	    
		category.setCategoryId(categoryId);
		savedCategory = categoryRepository.save(category);
		return savedCategory;

	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
}
