package com.jaclynn.FoodByFabio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.Portion;

@Repository
public interface PortionRepository extends CrudRepository<Portion, Long>{
	List<Portion> findAll();

}
