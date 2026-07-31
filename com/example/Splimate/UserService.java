package com.example.Splimate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
/*this below annotion tells to spting boot please find the user repository object and assign into this
	variable name userrepository instaed of 
	public UserService(UserRepository userrepo){
	this.userrepo=userrepo;
	who is creating the UserRepository object?
	A) Spring Container crtaes and injects that object into userrepo variable
	*/
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private JwtUtil jwtutil;
	public User savedUser(User u) {
		User existinguser=userrepo.findByEmail(u.getEmail());
		if(existinguser!=null) {
			throw new RuntimeException("Email alredy Existed");
		}
		User existingusername=userrepo.findByUsername(u.getUsername());
		if(existingusername!=null) {
			throw new RuntimeException("Username not find");
		}
		
		return userrepo.save(u);
	}
	public List<User> getAllUsers(){
		return userrepo.findAll();
	}
	public List<User> searchUsers(String keyword){
		return userrepo.findByUsernameContaining(keyword);
	}
	public String login(String username,String password) {
		User u=userrepo.findByUsername(username);
		if(u!=null && u.getPassword().equals(password)) {
			return jwtutil.generateToken(username);
		}
		return "Login Failed";
	}
}
