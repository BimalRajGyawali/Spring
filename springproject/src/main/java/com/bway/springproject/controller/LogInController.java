package com.bway.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bway.springproject.dao.UserDAO;
import com.bway.springproject.model.User;

@Controller
public class LogInController {
	
	@Autowired
	private UserDAO userdao;
	
	
	@RequestMapping(value ="/userlogin", method = RequestMethod.GET )
	public String getLogInForm()
	{
		return "login";
	}
	
	
	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	//We are going to fetch the data
	public String userLogin(@ModelAttribute User user, Model model) //user is set with values password and username
 	{
		if(userdao.login(user.getUsername(), user.getPassword()) != null) {
			
			
			model.addAttribute("user", user.getUsername());
			
			
			return "home";
		}
		
		
		model.addAttribute("error", "User "+user.getUsername()+" doesnot exist");
		return "login";
 	}
	

}
