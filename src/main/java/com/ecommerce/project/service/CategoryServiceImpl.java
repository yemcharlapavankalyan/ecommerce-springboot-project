package com.ecommerce.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.project.controller.model.Category;
import com.ecommerce.project.exceptions.APIException;
import com.ecommerce.project.exceptions.ResourceNotFoundException;
import com.ecommerce.project.repositories.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	
	
	@Override
	public List<Category> getAllCategories(){
		List<Category> categories = categoryRepository.findAll();
		if(categories.isEmpty()) {
			throw new APIException("No category is created till now");
		}else
		return categories;
	}
	
	@Override
	public void createCategory(Category category) {
		Category savedCategory = categoryRepository.findByCategoryName(category.getCategoryName());
		if(savedCategory != null) {
			throw new APIException("Category with the name "+ category.getCategoryName()+" Already exists.");
		}
		categoryRepository.save(category);
	
	}
	
	@Override
	public String deleteCategory(Long categoryId) {
		
		Category category = categoryRepository.findById(categoryId)
							.orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));
		
		categoryRepository.delete(category);
		return "Category with categoryId: "+ categoryId + " deleted Sucessfully";
		
	}
	
	
	

	@Override
	public Category updateCategory(Category category, Long categoryId) {

	    Category existingCategory = categoryRepository.findById(categoryId)
	            .orElseThrow(() -> new ResourceNotFoundException("Category","categoryId",categoryId));

	    existingCategory.setCategoryName(category.getCategoryName());

	    return categoryRepository.save(existingCategory);
	}


	
	
}
