package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.Products;
import com.spring.service.DataDAO;

@Controller
public class DataController {

	@Autowired
	DataDAO dao;

	@RequestMapping(value = "/addproducts", method = RequestMethod.GET)
	@ResponseBody
	public String addData() {
		System.out.println("controller");
		dao.InsertData();
		return "<h1>Successful</h1>";
	}

	@RequestMapping(value = "/delproducts", method = RequestMethod.GET)
	@ResponseBody
	public String delData() {
		System.out.println("del controller");
		dao.deleteProductById(2);
		return "<h1>Successful</h1>";
	}

	@RequestMapping(value = "/getAllproducts", method = RequestMethod.GET)
	public String getData(Model model) {
		System.out.println("get controller");
		List<Products> p = dao.getAllProducts();
		model.addAttribute("allproducts", p);
		return "AllProducts";
	}
}