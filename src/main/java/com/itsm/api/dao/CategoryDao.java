package com.itsm.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsm.api.models.Category;

public interface CategoryDao extends JpaRepository<Category, Long>{

}
