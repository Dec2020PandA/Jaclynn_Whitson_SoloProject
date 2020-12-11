package com.jaclynn.FoodByFabio.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.jaclynn.FoodByFabio.models.Carb;
import com.jaclynn.FoodByFabio.models.Meat;
import com.jaclynn.FoodByFabio.models.PickupLocation;
import com.jaclynn.FoodByFabio.models.Portion;
import com.jaclynn.FoodByFabio.models.Veggie;
import com.jaclynn.FoodByFabio.services.MealService;
import com.jaclynn.FoodByFabio.services.OrderService;
import com.jaclynn.FoodByFabio.services.UserService;


@Controller
public class MainController {
	@Autowired
	private UserService uService;
	@Autowired
	private MealService mService;
	@Autowired
	private OrderService oService;
	
	@GetMapping("/home")
	public String home(Model viewModel, HttpSession session) {

		return "home.jsp";
	}
	
//SECTION COVERS ADMIN ADDING INGREDIENTS, PORTIONS, AND PICKUP LOCATIONS	
	
	@GetMapping("/admin/add")
	public String admin(@ModelAttribute("meat") Meat meat, @ModelAttribute("carb") Carb carb, @ModelAttribute("veggie") Veggie veggie, @ModelAttribute("portion")Portion portion, @ModelAttribute("pickuplocation") PickupLocation pickuplocation) {
		return "adminAdd.jsp";
	}
	
	@PostMapping("/meats/new")
	public String addMeat(@Valid @ModelAttribute("meat") Meat meat, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "adminAdd.jsp";
		}
		mService.saveMeat(meat);
		return "redirect:/admin/add";
	}
	@PostMapping("/carbs/new")
	public String addCarb(@Valid @ModelAttribute("carb") Carb carb, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "adminAdd.jsp";
		}
		mService.saveCarb(carb);
		return "redirect:/admin/add";
	}
	@PostMapping("/veggies/new")
	public String addVeggie(@Valid @ModelAttribute("veggie") Veggie veggie, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "adminAdd.jsp";
		}
		mService.saveVeggie(veggie);
		return "redirect:/admin/add";
	}
	@PostMapping("/portions/new")
	public String addPortion(@Valid @ModelAttribute("portion") Portion portion, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "adminAdd.jsp";
		}
		mService.savePortion(portion);
		return "redirect:/admin/add";
	}
	@PostMapping("/pickuplocations/new")
	public String addPickup(@Valid @ModelAttribute("pickuplocation") PickupLocation pickuplocation, BindingResult result, HttpSession session) {
		if(result.hasErrors()) {
			return "adminAdd.jsp";
		}
		oService.savePickupLocation(pickuplocation);
		return "redirect:/admin/add";
	}
}
