package com.jaclynn.FoodByFabio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.Carb;

@Repository
public interface CarbRepository extends CrudRepository<Carb, Long>{
	List<Carb> findAll();

}
