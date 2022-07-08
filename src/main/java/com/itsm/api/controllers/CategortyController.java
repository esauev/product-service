package com.itsm.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsm.api.models.Category;
import com.itsm.api.services.CategoryService;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/ps/category")
public class CategortyController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/list")
	public ResponseEntity<List<Category>> getListCategory(){
		return new ResponseEntity<List<Category>>(categoryService.findAll(),
				HttpStatus.OK);
	}

}
