package com.spring.service;

import java.util.List;

import com.spring.model.Products;

public interface DataDAO {
	void InsertData();

	public void saveProduct(Products product);

	public void deleteProductById(Integer id);

	public List<Products> getAllProducts();
}