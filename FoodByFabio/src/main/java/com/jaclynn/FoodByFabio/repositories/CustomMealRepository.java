package com.jaclynn.FoodByFabio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.CustomMeal;
import com.jaclynn.FoodByFabio.models.Order;

@Repository
public interface CustomMealRepository extends CrudRepository<CustomMeal, Long> {
	List<CustomMeal> findAll();
	List<CustomMeal> findAllByOrders(Order order);
}
