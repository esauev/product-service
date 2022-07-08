package com.itsm.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsm.api.dao.ProductDao;
import com.itsm.api.models.Product;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductDao productDao;

	@Override
	public Product save(Product product) {
		return productDao.save(product);
	}

	@Override
	public Product findById(Long productId) {
		return productDao.findById(productId).orElse(null);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public void delete(Long productId) {
		productDao.deleteById(productId);
	}

}
