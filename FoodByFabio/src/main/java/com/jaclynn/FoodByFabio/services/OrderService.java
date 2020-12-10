package com.jaclynn.FoodByFabio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.FoodByFabio.models.Order;
import com.jaclynn.FoodByFabio.repositories.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository oRepo;
	
	//find one user by ID
	public Order findOneOrder(Long id) {
		return this.oRepo.findById(id).orElse(null);
	}
	//get all
	public List<Order> getAllOrders(){
		return this.oRepo.findAll();
	}
	//create order
	public Order saveOrder(Order order) {
		return this.oRepo.save(order);
	}
	

}
