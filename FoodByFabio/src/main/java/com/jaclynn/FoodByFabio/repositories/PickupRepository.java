package com.jaclynn.FoodByFabio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.PickupLocation;

@Repository
public interface PickupRepository extends CrudRepository<PickupLocation, Long>{
	List<PickupLocation> findAll();

}
