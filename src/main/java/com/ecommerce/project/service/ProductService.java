package com.ecommerce.project.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.ecommerce.project.model.Product;
import com.ecommerce.project.payload.ProductDTO;
import com.ecommerce.project.payload.ProductResponse;

public interface ProductService {

	ProductDTO addProduct(Long categoryId, ProductDTO productDTO);

	
	ProductResponse getAllProducts();


	ProductResponse searchByCategory(Long categoryId);


	ProductResponse searchByCategoryByKeyword(String keyword);




	ProductDTO deleteProduct(Long productId);


	ProductDTO updateProduct(Long productId, ProductDTO productDTO);


	ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException;
}
