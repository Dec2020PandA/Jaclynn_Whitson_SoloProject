package com.jaclynn.FoodByFabio.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jaclynn.FoodByFabio.models.Carb;
import com.jaclynn.FoodByFabio.models.CustomMeal;
import com.jaclynn.FoodByFabio.models.Meat;
import com.jaclynn.FoodByFabio.models.Order;
import com.jaclynn.FoodByFabio.models.PickupLocation;
import com.jaclynn.FoodByFabio.models.Portion;
import com.jaclynn.FoodByFabio.models.QuickMeal;
import com.jaclynn.FoodByFabio.models.User;
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
	
	//to store images of meals
	private static String UPLOADED_FOLDER = "src/main/resources/images/";
	
	
	
	@GetMapping("/home")
	public String home(Model viewModel, HttpSession session) {
		//validates user is logged in and displays user name on page
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.findOneUser(userId);
		viewModel.addAttribute("user", user);
		
		return "home.jsp";
	}
	
//SECTION COVERS CUSTOM MEAL PAGE
	@GetMapping("/custommeals")
	public String showCustom(Model viewModel,   @ModelAttribute("meats") Meat meat, @ModelAttribute("carbs") Carb carb, @ModelAttribute("veggies") Veggie veggie, @ModelAttribute("meatPortions") Portion meatPortion, @ModelAttribute("carbPortions") Portion carbPortion, @ModelAttribute("vegPortions") Portion vegPortion, HttpSession session) {
		//validates user is logged in and displays user name on page
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user_id");
		User user = this.uService.findOneUser(userId);
		viewModel.addAttribute("user", user);
		
		List<Meat> meats = this.mService.getAllMeats();
		viewModel.addAttribute("meats", meats);
		List<Carb> carbs = this.mService.getAllCarbs();
		viewModel.addAttribute("carbs", carbs);
		List<Veggie> veggies = this.mService.getAllVeggies();
		viewModel.addAttribute("veggies", veggies);
		List<Portion> portions = this.mService.getAllPortions();
		viewModel.addAttribute("portions", portions);
		return "customize.jsp";
	}
	

//SECTION COVERS QUICK MEAL PAGE
	@GetMapping("/quickmeals")
	public String showQuick(Model viewModel, @ModelAttribute("quickMeal") QuickMeal quickmeal, HttpSession session) {
		//validates user is logged in and displays user name on page
		if(session.getAttribute("user_id") == null) {
			return "redirect:/";
		}
		Long userId = (Long)session.getAttribute("user_id");
		
		List<QuickMeal> meals = this.mService.getAllQuickMeals();
		viewModel.addAttribute("quickMeals", meals);
		return "quickmeal.jsp";
	}
	
	@PostMapping("/addQuickMeal")
	public String addOrder(@RequestParam("meal") Long id,  HttpSession session) {
		System.out.println(id);
		//get the order from the session
		Long order_id = (Long)session.getAttribute("order_id");
		System.out.println(order_id);
		Order order = this.oService.findOneOrder(order_id);
		//Get the selected meal from the page
		QuickMeal qMeal = this.mService.findByIdQuick(id);
		//add the meal to the order		
		List<QuickMeal> meals = order.getQuickmeals();
		meals.add(qMeal);
		order.setQuickmeals(meals);		
		this.oService.addQuickMealsToOrder(order, qMeal);
		//add the order to the quick meal
		//this.mService.addOrderToQuickMeal(meal, order);
		
		return "redirect:/home";
	}
	
//SECTION COVERS ADMIN ADDING INGREDIENTS, PORTIONS, AND PICKUP LOCATIONS	
	
	@GetMapping("/admin/add")
	public String admin(@ModelAttribute("quickmeal") QuickMeal quickmeal, @ModelAttribute("meat") Meat meat, @ModelAttribute("carb") Carb carb, @ModelAttribute("veggie") Veggie veggie, @ModelAttribute("portion")Portion portion, @ModelAttribute("pickuplocation") PickupLocation pickuplocation) {
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
	
	@PostMapping("/quickmeals/new")
	public String addQuick(@Valid @ModelAttribute("quickmeal") QuickMeal quickmeal, BindingResult result) {
		if(result.hasErrors()) {
			return "adminAdd.jsp";
		}
		mService.saveQuickMeal(quickmeal);
		return "redirect:/admin/add";
	}
	
	
	//For adding a picture 
	@PostMapping("/quickmeal/new")
	public String addQuick(@RequestParam("image") MultipartFile file, @RequestParam("name") String name, @RequestParam("description") String desc, @RequestParam("price") float price, RedirectAttributes redirectAttr, QuickMeal quickmeal) {
		if(desc.isEmpty()) {
			redirectAttr.addFlashAttribute("message","Description cannot be empty");
			return "redirect:/admin/add";
		}
		if(name.isEmpty()) {
			redirectAttr.addFlashAttribute("message","Name cannot be empty");
			return "redirect:/admin/add";
		}
		try {
			//get the file and save it somewhere
			byte[] bytes = file.getBytes();
			Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes);
			//get url of file just uploaded
			String url = "/images/" + file.getOriginalFilename();
			this.mService.saveQuickMeal(name, desc, price, url);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return "redirect:/admin/add";
	}
}
