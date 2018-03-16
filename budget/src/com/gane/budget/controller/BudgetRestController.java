package com.gane.budget.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/restapi")
public class BudgetRestController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value = "check1")
	public @ResponseBody HashMap<String, String> verify1(@RequestParam(value = "name") String name) {
		
		HashMap<String, String> map = new HashMap<>();
		String temp = jdbcTemplate.queryForObject("select ifnull((select slno from test where name='" + name + "'), '') as id", String.class);
		map.put("message", temp);
		map.put("name", name);
		return map;
	}
	
	@RequestMapping(value = "registerUser", method = RequestMethod.POST)
	public Object addUser(@RequestBody HashMap<String, String> params, HttpServletRequest request) {
		// create a user
		// create default categories and subcategories
		return params;
	}
}
