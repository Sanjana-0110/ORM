package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Products;
import com.spring.repository.DataRepository;

@Service
public class DataService implements DataDAO {
	@Autowired
	DataRepository dr;
	@Autowired
	Products dm;

	@Override
	public void InsertData() {
		// TODO Auto-generated method stub
		dm.setItemName("Kurkure");
		dr.save(dm);
		System.out.println("data successfully added");

	}

	public void getProductById(Integer id) {
		Products p = dr.findById(id).orElse(null);
		System.out.println(p);
	}

	public void saveProduct(Products product) {
		dr.save(product);
	}

	@Override
	public void deleteProductById(Integer id) {
		// TODO Auto-generated method stub
		dr.deleteById(id);
		System.out.println("data successfully Deleted");
	}

	public List<Products> getAllProducts() {
		return dr.findAll();
	}
}