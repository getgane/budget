package com.gane.budget.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class BudgetController {

	@Autowired
	JdbcTemplate jdbcTemplate;


	@RequestMapping("home")
	public ModelAndView gotoHome() {
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
	
	@RequestMapping("check")
	public ModelAndView verify(@RequestParam(value = "name") String name) {
		ModelAndView mav = new ModelAndView("hello");
		System.out.println(mav.getViewName());
		String temp = jdbcTemplate.queryForObject("select ifnull((select slno from test where name='" + name + "'), '') as id", String.class);
		mav.addObject("message", temp);
		mav.addObject("name", name);
		return mav;
	}

	@RequestMapping("registerUser")
	public ModelAndView addUser(@RequestParam(value = "userName") String userName, @RequestParam(value = "firstName") String firstName, 
			@RequestParam(value = "lastName") String lastName, @RequestParam(value = "email") String email,
			@RequestParam(value = "mobile") String moblie, @RequestParam(value = "sex") String sex,
			@RequestParam(value = "dateOfBirth") String dateOfBirth, @RequestParam(value = "password") String password,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("hello");
		System.out.println(mav.getViewName());
		
		mav.addObject("message", request.getParameterMap());
		System.out.println(request.getParameterMap());
		return mav;
	}
	
	@RequestMapping("html/{page}")
	public String htmlRedirector(@PathVariable String page) {
		return page;
	}
}
