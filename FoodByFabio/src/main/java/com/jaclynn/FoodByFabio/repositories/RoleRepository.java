package com.jaclynn.FoodByFabio.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jaclynn.FoodByFabio.models.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

}
