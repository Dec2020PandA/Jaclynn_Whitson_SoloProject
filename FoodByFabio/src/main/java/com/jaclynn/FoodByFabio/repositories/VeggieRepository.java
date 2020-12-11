package com.jaclynn.FoodByFabio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.Veggie;

@Repository
public interface VeggieRepository extends CrudRepository<Veggie, Long>{
	List<Veggie> findAll();

}
