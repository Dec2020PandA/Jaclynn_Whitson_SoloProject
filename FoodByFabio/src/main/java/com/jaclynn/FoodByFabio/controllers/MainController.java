package com.jaclynn.FoodByFabio.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.jaclynn.FoodByFabio.services.UserService;


@Controller
public class MainController {
	@Autowired
	private UserService uService;
	
	@GetMapping("/home")
	public String home(Model viewModel, HttpSession session) {

		return "home.jsp";
	}

}
