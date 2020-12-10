package com.jaclynn.FoodByFabio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.CustomMeal;
import com.jaclynn.FoodByFabio.models.Ingredient;
import com.jaclynn.FoodByFabio.models.RandomMeal;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	List<Ingredient> findAll();
	List<Ingredient> findByCustomMealsContaining(CustomMeal customMeal);
	List<Ingredient> findByRandomMealsContaining(RandomMeal randomMeal);

}
