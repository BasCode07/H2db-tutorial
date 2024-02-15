package com.bascode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bascode.model.User;
import com.bascode.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> getAllUser(){
		if(repository.findAll().isEmpty()) {
			return List.of();
		}
		return repository.findAll();
	}
	
	public User creatUser(User user) {
		if(user == null) {
			throw new RuntimeException("body must not be null");
		}
		return repository.save(user);
	}
	
	public User updateUser(User user, long id) {
	   User checkUser = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("No user found"));
	   checkUser.setName(user.getName());
	   checkUser.setEmail(user.getEmail());
	   return repository.save(checkUser);
		
	}
	
	public String deleteUser(long id) {
		User user =repository.findById(id)
		.orElseThrow(()-> new RuntimeException("No user found"));
		repository.delete(user);
		return "User with id: "+id+" deleted successfully";
	}
	
	public User getUserById(long id) {
		User checkUser = repository.findById(id).
				orElseThrow(() -> new RuntimeException("No user found"));
		return checkUser;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
