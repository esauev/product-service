package com.itsm.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsm.api.models.Product;
import com.itsm.api.services.ProductService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/ps/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Product>> getListProduct() {
		return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable Long id){
		return new ResponseEntity<Product>(productService.findById(id),
				HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		return new ResponseEntity<Product>(productService.save(product),
				HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable Long id,
			@RequestBody Product product){
		Product productBd = productService.findById(id);
		
		if (productBd==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		try {
			productBd.setName(product.getName());
			productBd.setPrice(product.getPrice());
			productBd.setImage(product.getImage());
			productBd.setCategory(product.getCategory());
			
			return new ResponseEntity<Product>(productService.save(productBd),
					HttpStatus.CREATED);
		} catch (DataAccessException e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Long id){
		productService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
		
}

	
	
	
	