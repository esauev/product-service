package com.itsm.api.services;

import java.util.List;

import com.itsm.api.models.Product;

public interface ProductService {
	
	public Product save(Product product);
	
	public Product findById(Long productId);
	
	public List<Product> findAll();
	
	public void delete(Long productId);

}
