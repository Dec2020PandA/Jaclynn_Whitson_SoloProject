package com.jaclynn.FoodByFabio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.CustomMeal;

@Repository
public interface CustomMealRepository extends CrudRepository<CustomMeal, Long> {
	List<CustomMeal> findAll();
}
