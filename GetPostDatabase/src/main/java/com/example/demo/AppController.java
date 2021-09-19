package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
public class AppController {
	@Autowired
	UserService service;
	@RequestMapping("/")
	public String viewHomePage(Model model)
	
	{
		List<User> listUser =service.listAll();
		
		model.addAttribute("listUser",listUser);
		return "index" ;
	}
	@RequestMapping("/new")
	public String ShownewUser(Model model) {
		User user=new User();
		model.addAttribute("user",user);
		return "newuser";
	}
	
	@RequestMapping(value="/save",method =RequestMethod.POST)
	public String saveUser(@ModelAttribute("user") User user) {
		service.save(user);
		
		
		return "success";
	}
	
	
		
		
	
	
}
