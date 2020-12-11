package com.jaclynn.FoodByFabio.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.jaclynn.FoodByFabio.models.Carb;
import com.jaclynn.FoodByFabio.models.Meat;
import com.jaclynn.FoodByFabio.models.PickupLocation;
import com.jaclynn.FoodByFabio.models.Portion;
import com.jaclynn.FoodByFabio.models.Veggie;
import com.jaclynn.FoodByFabio.services.UserService;


@Controller
public class MainController {
	@Autowired
	private UserService uService;
	
	@GetMapping("/home")
	public String home(Model viewModel, HttpSession session) {

		return "home.jsp";
	}
	
	@GetMapping("/admin/add")
	public String admin(@ModelAttribute("meat") Meat meat, @ModelAttribute("carb") Carb carb, @ModelAttribute("veggie") Veggie veggie, @ModelAttribute("portion")Portion portion, @ModelAttribute("pickuplocation") PickupLocation pickuplocation) {
		return "adminAdd.jsp";
	}

}
