package com.jaclynn.FoodByFabio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.FoodByFabio.models.CustomMeal;
import com.jaclynn.FoodByFabio.models.QuickMeal;
import com.jaclynn.FoodByFabio.models.RandomMeal;
import com.jaclynn.FoodByFabio.repositories.CustomMealRepository;
import com.jaclynn.FoodByFabio.repositories.IngredientRepository;
import com.jaclynn.FoodByFabio.repositories.QuickMealRepository;
import com.jaclynn.FoodByFabio.repositories.RandomMealRepository;

@Service
public class MealService {
	@Autowired
	private CustomMealRepository cRepo;
	@Autowired
	private QuickMealRepository qRepo;
	@Autowired
	private RandomMealRepository rRepo;
	@Autowired
	private IngredientRepository iRepo;
	
	//Get all
	public List<CustomMeal> getAllCustomMeals(){
		return this.cRepo.findAll();
	}
	public List<QuickMeal> getAllQuickMeals(){
		return this.qRepo.findAll();		
	}
	public List<RandomMeal> getAllRandomMeals(){
		return this.rRepo.findAll();
	}
	
	//Get One
	public CustomMeal findByIdCustom(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	public QuickMeal findByIdQuick(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	public RandomMeal findByIdRandom(Long id) {
		return this.rRepo.findById(id).orElse(null);
	}
	//Create or update
	public CustomMeal saveCustom(CustomMeal meal) {
		return this.cRepo.save(meal);
		}
	public QuickMeal saveQuickMeal(QuickMeal meal) {
		return this.qRepo.save(meal);
	}
	public RandomMeal saveRandomMeal(RandomMeal meal) {
		return this.rRepo.save(meal);
	}
	


}
