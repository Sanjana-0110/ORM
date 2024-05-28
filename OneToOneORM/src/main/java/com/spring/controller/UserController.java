package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.User;
import com.spring.service.UserDAO;

@Controller
public class UserController {

	@Autowired
	UserDAO dao;

	@RequestMapping(value = "/adduser", method = RequestMethod.GET)
	@ResponseBody
	public String addData() {
		System.out.println("insert controller");
		dao.saveUser();
		return "<h1>Successful</h1>";
	}

	// @RequestMapping(value = "/delproducts", method = RequestMethod.GET)
	// @ResponseBody
	// public String delData() {
	// System.out.println("del controller");
	// dao.deleteProductById(2);
	// return "<h1>Successful</h1>";
	// }

	@RequestMapping(value = "/getAllusers", method = RequestMethod.GET)
	public String getData(Model model) {
		System.out.println("get controller");
		List<User> p = dao.getUsers();
		model.addAttribute("allusers", p);
		return "AllUsers";
	}
}
