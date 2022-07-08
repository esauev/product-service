package com.itsm.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itsm.api.models.Product;

public interface ProductDao extends JpaRepository<Product, Long>{

}
