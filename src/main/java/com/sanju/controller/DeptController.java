package com.sanju.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sanju.dao.DeptDAO;
import com.sanju.model.Dept;

@Controller
public class DeptController {

	DeptDAO ddao;

	@Autowired
	public DeptController(DeptDAO dptdao) {

		ddao = dptdao;

	}

	@RequestMapping(value = "/deptlist", method = RequestMethod.GET)
	public String getAllDepts(Model model) {

		System.out.println("Departments List JSP Requested");

		// get all Departments from DAO

		List<Dept> deptList = ddao.findAll();

		// set it to the model

		model.addAttribute("dlist", deptList);

		// call the view

		return "deptlist";

	}

}
