package com.jaclynn.FoodByFabio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.CustomMeal;
import com.jaclynn.FoodByFabio.models.Recipe;
import com.jaclynn.FoodByFabio.models.RandomMeal;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	List<Recipe> findAll();
	List<Recipe> findByCustomMealsContaining(CustomMeal customMeal);
	List<Recipe> findByRandomMealsContaining(RandomMeal randomMeal);

}
