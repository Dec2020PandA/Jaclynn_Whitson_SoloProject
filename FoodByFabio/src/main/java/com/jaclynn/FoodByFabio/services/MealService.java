package com.jaclynn.FoodByFabio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.FoodByFabio.models.Carb;
import com.jaclynn.FoodByFabio.models.CustomMeal;
import com.jaclynn.FoodByFabio.models.Meat;
import com.jaclynn.FoodByFabio.models.Order;
import com.jaclynn.FoodByFabio.models.Portion;
import com.jaclynn.FoodByFabio.models.QuickMeal;
import com.jaclynn.FoodByFabio.models.RandomMeal;
import com.jaclynn.FoodByFabio.models.Recipe;
import com.jaclynn.FoodByFabio.models.Veggie;
import com.jaclynn.FoodByFabio.repositories.CarbRepository;
import com.jaclynn.FoodByFabio.repositories.CustomMealRepository;
import com.jaclynn.FoodByFabio.repositories.MeatRepository;
import com.jaclynn.FoodByFabio.repositories.PortionRepository;
import com.jaclynn.FoodByFabio.repositories.QuickMealRepository;
import com.jaclynn.FoodByFabio.repositories.RandomMealRepository;
import com.jaclynn.FoodByFabio.repositories.RecipeRepository;
import com.jaclynn.FoodByFabio.repositories.VeggieRepository;

@Service
public class MealService {
	@Autowired
	private CustomMealRepository cRepo;
	@Autowired
	private QuickMealRepository qRepo;
	@Autowired
	private RandomMealRepository rRepo;
	@Autowired
	private RecipeRepository iRepo;
	@Autowired 
	private MeatRepository mRepo;
	@Autowired
	private CarbRepository carbRepo;
	@Autowired
	private VeggieRepository vRepo;
	@Autowired
	private PortionRepository pRepo;
	
	
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
	public List<Meat> getAllMeats(){
		return this.mRepo.findAll();
	}
	public List<Carb> getAllCarbs(){
		return this.carbRepo.findAll();
	}
	public List<Veggie> getAllVeggies(){
		return this.vRepo.findAll();
	}
	public List<Portion> getAllPortions(){
		return this.pRepo.findAll();
	}
	public List<Recipe> getAllRecipes(){
		return this.iRepo.findAll();
	}

//get all meals by order
	public List<CustomMeal> getAllCustomMealsByOrder(Order order){
		return this.cRepo.findAllByOrders(order);
	}
	public List<QuickMeal> getAllQuickMealsByOrder(Order order){
		return this.qRepo.findAllByOrders(order);
	}
	public List<RandomMeal> getAllRandomMealsByOrder(Order order){
		return this.rRepo.findAllByOrders(order);
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
	public Portion findByIdPortion(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	public Meat findByIdMeat(Long id) {
		return this.mRepo.findById(id).orElse(null);
	}
	public Carb findByIdCarb(Long id) {
		return this.carbRepo.findById(id).orElse(null);
	}
	public Veggie findByIdVeggie(Long id) {
		return this.vRepo.findById(id).orElse(null);
	}
	public Recipe findByIdRecipe(Long id) {
		return this.iRepo.findById(id).orElse(null);
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
	public Portion savePortion(Portion portion) {
		return this.pRepo.save(portion);
	}
	public Meat saveMeat(Meat meat) {
		return this.mRepo.save(meat);
	}
	public Carb saveCarb(Carb carb) {
		return this.carbRepo.save(carb);
	}
	public Veggie saveVeggie(Veggie veggie) {
		return this.vRepo.save(veggie);
	}
	public Recipe saveRecipe(Recipe recipe) {
		return this.iRepo.save(recipe);
	}
	
	//create quickmeal with an image
	public QuickMeal saveQuickMealImages(String name, String desc, Float price, String url) {
		QuickMeal meal = new QuickMeal(name, desc, price, url);
		return this.qRepo.save(meal);
	}
	
	//add an order to the list of orders for quick meals
	public QuickMeal addOrderToQuickMeal(QuickMeal meal, Order order) {
		//get the list of orders
		List<Order> orders = meal.getOrders();
		//add the order to the list
		orders.add(order);
		return this.qRepo.save(meal);
	}
	
	
	//delete
	public void deleteCustomMeal(Long id) {
		this.cRepo.deleteById(id);
	}
	public void deleteRandomMeal(Long id) {
		this.rRepo.deleteById(id);
	}
	public void deleteQuickMeal(Long id) {
		this.qRepo.deleteById(id);
	}
	//only need to delete recipes since the ingredients are combined
	public void deleteRecipe(Long id) {
		this.iRepo.deleteById(id);
	}

}