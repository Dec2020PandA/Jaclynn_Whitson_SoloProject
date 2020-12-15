package com.jaclynn.FoodByFabio.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jaclynn.FoodByFabio.models.Order;
import com.jaclynn.FoodByFabio.models.User;
import com.jaclynn.FoodByFabio.services.OrderService;
import com.jaclynn.FoodByFabio.services.UserService;
import com.jaclynn.FoodByFabio.validators.UserValidator;


@Controller
public class UserController {
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	@Autowired
	private OrderService oService;
	
	@RequestMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "loginlanding.jsp";
	}
	
	@GetMapping("/register")
	public String reg(@ModelAttribute("user") User user) {
		return "register.jsp";
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
		validator.validate(user, result);
		if(result.hasErrors()) {
			return "register.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user_id", newUser.getId());
		return "redirect:/home";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("lEmail") String email, @RequestParam("lPassword") String passowrd, RedirectAttributes redirectAttrs, HttpSession session) {
		if(!this.uService.authenticateUser(email, passowrd)) {
			redirectAttrs.addFlashAttribute("loginError", "YOU SHALL NOT PASS!! Invalid credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user_id", user.getId());
		Order newOrder = new Order();
		newOrder.setCustomer(user);
		this.oService.saveOrder(newOrder);
		
				
		//change the return to the home page
		return "redirect:/home";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}



