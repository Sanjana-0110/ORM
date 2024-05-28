package com.spring.service;

import java.util.List;

import com.spring.model.User;

public interface UserDAO {
	public List<User> getUsers();

	public void saveUser();
}
