package com.example.Splimate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Expense {
	   @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	   private String description;
	   private Double amount;
	   
	   @ManyToOne
	   @JoinColumn(name="member_id")
	   private Member paidBy;
	   @ManyToOne
	   @JoinColumn(name="group_id")
	   private GroupEntity group;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public Member getPaidBy() {
		return paidBy;
	}
	public void setPaidBy(Member paidBy) {
		this.paidBy = paidBy;
	}
	public GroupEntity getGroup() {
		return group;
	}
	public void setGroup(GroupEntity group) {
		this.group = group;
	}
	   
}
