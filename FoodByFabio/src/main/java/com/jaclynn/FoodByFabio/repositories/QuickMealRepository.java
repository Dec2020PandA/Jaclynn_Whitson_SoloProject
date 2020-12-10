package com.jaclynn.FoodByFabio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.QuickMeal;

@Repository
public interface QuickMealRepository extends CrudRepository<QuickMeal, Long>{
	List<QuickMeal> findAll();

}
