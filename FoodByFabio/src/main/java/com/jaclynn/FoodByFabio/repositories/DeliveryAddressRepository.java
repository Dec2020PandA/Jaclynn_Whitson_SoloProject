package com.jaclynn.FoodByFabio.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.DeliveryAddress;

@Repository
public interface DeliveryAddressRepository extends CrudRepository<DeliveryAddress, Long>{
	List<DeliveryAddress> findAll();
}
