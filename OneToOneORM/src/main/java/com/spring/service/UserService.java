package com.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.model.Address;
import com.spring.model.User;
import com.spring.repository.UserRepository;

@Service
public class UserService implements UserDAO {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private User u;

	@Autowired
	private Address a;

	public void saveUser() {

		a.setCity("mumbai");
		a.setStreet("aroli");
		u.setName("asha");
		u.setAddress(a);
		userRepository.save(u);

		System.out.println("data successfully added");

	}

	public List<User> getUsers() {
		return userRepository.findAll();
	}

}
