package com.example.Splimate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity //it is a JPA annotation this class belongs to table in DB and every object or feild consider as column
public class User { //this is for database table with required feilds

	@Id  // it is a JPA Annotation it tells to Hibernate this feild is a primary key in table
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	private String name;
	
	private String email;
	
	private String password;
	@Column(unique=true)
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public User() {
		//this is for hibernate need this to create object first when hibernate reads data from mysql
		//it first creates an empty constructor then only fills all feilds.
	}
	/*parameterized constructor no need as of now because we are using setters and getters 
	 to seta nd get value so no parameterized constructor */
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
