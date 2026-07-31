package com.example.Splimate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Member {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private long id;
private String membername;
private String email;

@ManyToOne
@JoinColumn(name="group_id")
private GroupEntity groupentity;
public Member() {
	
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getMembername() {
	return membername;
}
public void setMembername(String membername) {
	this.membername = membername;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public GroupEntity getGroupEntity() {
	return groupentity;
}
public void setGroupEntity(GroupEntity groupentity) {
	this.groupentity=groupentity;
}
}
