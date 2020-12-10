package com.jaclynn.FoodByFabio.services;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jaclynn.FoodByFabio.models.Role;
import com.jaclynn.FoodByFabio.models.User;
import com.jaclynn.FoodByFabio.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	//Find one user by id
	public User findOneUser(Long id) {
		User user = this.uRepo.findById(id).orElse(null);
		return user;
	}
	//find a user by email
	public User getByEmail(String email) {
		return this.uRepo.findByEmail(email);
	}
	
	//find all users
	public List<User> allUsers(){
		return this.uRepo.findAll();
	}
	
	//register a new user
	public User registerUser(User newUser) {
		String hash = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hash);
		return this.uRepo.save(newUser);
	}
	
	//validating a user password on login
	public boolean authenticateUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
		if(user == null) {
			return false;
		}
		return BCrypt.checkpw(password, user.getPassword());
	}
	

}
