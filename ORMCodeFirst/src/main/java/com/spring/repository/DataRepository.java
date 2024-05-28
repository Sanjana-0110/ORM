package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Products;

public interface DataRepository extends JpaRepository<Products, Integer> {

}