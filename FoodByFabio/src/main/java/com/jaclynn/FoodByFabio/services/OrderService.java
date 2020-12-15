package com.jaclynn.FoodByFabio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.FoodByFabio.models.DeliveryAddress;
import com.jaclynn.FoodByFabio.models.Order;
import com.jaclynn.FoodByFabio.models.PickupLocation;
import com.jaclynn.FoodByFabio.models.QuickMeal;
import com.jaclynn.FoodByFabio.repositories.DeliveryAddressRepository;
import com.jaclynn.FoodByFabio.repositories.OrderRepository;
import com.jaclynn.FoodByFabio.repositories.PickupRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository oRepo;
	@Autowired
	private PickupRepository pickupRepo;
	@Autowired
	private DeliveryAddressRepository dRepo;
	
	//find one by ID
	public Order findOneOrder(Long id) {
		return this.oRepo.findById(id).orElse(null);
	}
	public PickupLocation findOnePickup(Long id) {
		return this.pickupRepo.findById(id).orElse(null);
	}
	public DeliveryAddress findOneDelivery(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	//get all
	public List<Order> getAllOrders(){
		return this.oRepo.findAll();
	}
	public List<PickupLocation> getAllPickupLocations(){
		return this.pickupRepo.findAll();
	}
	public List<DeliveryAddress> getAllDeliveryAddresses(){
		return this.dRepo.findAll();
	}
	
	//create or update order
	public Order saveOrder(Order order) {
		return this.oRepo.save(order);
	}
	
	public PickupLocation savePickupLocation(PickupLocation pickup) {
		return this.pickupRepo.save(pickup);
	}
	public DeliveryAddress saveDeliveryAddress(DeliveryAddress delivery) {
		return this.dRepo.save(delivery);
	}
	
	//create add meals to created order
	public Order addQuickMealsToOrder(Order order, QuickMeal meal) {

		//get the list of quick meals
		List<QuickMeal> qMeals = order.getQuickmeals();
		qMeals.add(meal);
		return this.oRepo.save(order);
	}
	
	

}
