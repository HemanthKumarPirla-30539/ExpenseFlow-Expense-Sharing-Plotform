package com.example.Splimate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	public UserService userservice;
	
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) {
		return userservice.savedUser(user);
		
	}
	@GetMapping("/get")
	public List<User> getAll(){
		return userservice.getAllUsers();
	}
	@GetMapping("/search")
	public List<User> searchUser(@RequestParam String keyword){
		return userservice.searchUsers(keyword);
	}
	@PostMapping("/login")
	public String login(@RequestBody User u) {
		return userservice.login(u.getUsername(), u.getPassword());
	} 
} 
