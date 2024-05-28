package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}