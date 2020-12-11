package com.jaclynn.FoodByFabio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.Meat;

@Repository
public interface MeatRepository extends CrudRepository<Meat, Long> {
	List<Meat> findAll();

}
