package com.itsm.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itsm.api.dao.CategoryDao;
import com.itsm.api.models.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDao categoryDao;

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}

}
