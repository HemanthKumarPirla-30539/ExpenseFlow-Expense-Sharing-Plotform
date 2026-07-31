package com.example.Splimate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GroupEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private String groupname;
private String username;
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public GroupEntity() {
	
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getGroupname() {
	return groupname;
}
public void setGroupname(String groupname) {
	this.groupname = groupname;
}


}
