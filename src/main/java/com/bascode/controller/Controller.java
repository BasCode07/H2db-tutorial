package com.bascode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bascode.model.User;
import com.bascode.service.UserService;

@RestController
@RequestMapping("/api")
public class Controller {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/users")
	private ResponseEntity<List<User>> getAllUser(){
		List<User> user = service.getAllUser();
		return ResponseEntity.ok(user);
	}
	
	@PostMapping("/create")
	private ResponseEntity<User> createUser(@RequestBody User user){
		User createUser = service.creatUser(user);
		return new ResponseEntity<>(createUser, HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	private ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		User updateUser = service.updateUser(user, id);
		return new ResponseEntity<User>(updateUser, HttpStatus.OK);
	}
	
	@GetMapping("/find/{id}")
	private ResponseEntity<User> findById(@PathVariable("id") long id){
		User user = service.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	@DeleteMapping("/delete/{id}")
	private ResponseEntity<String> deleteUser(@PathVariable("id") long id){
		return ResponseEntity.ok(service.deleteUser(id));
	}
	
	
	
	

}
