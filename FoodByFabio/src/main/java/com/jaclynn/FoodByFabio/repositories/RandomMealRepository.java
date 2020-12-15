package com.jaclynn.FoodByFabio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.Order;
import com.jaclynn.FoodByFabio.models.RandomMeal;

@Repository
public interface RandomMealRepository extends CrudRepository<RandomMeal, Long> {
	List<RandomMeal> findAll();
	List<RandomMeal> findAllByOrders(Order order);
}
