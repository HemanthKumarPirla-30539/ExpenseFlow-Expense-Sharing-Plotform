package com.example.Splimate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/expense")
public class ExpenseController {

	@Autowired
	ExpenseService expenseservice;
	@Autowired
	ExpenseRepository expenserepository;
	@PostMapping("/add")
	public Expense expense(@RequestBody Expense expense,
						   @RequestParam Long memberId,
						   @RequestParam Long groupId) {
		
		return expenseservice.addExpense(expense, memberId, groupId);
	}
	@GetMapping("/groups") 
	public List<Expense> getGroupExpenseByGroup(@RequestParam Long groupId){
		return expenseservice.getExpensesByGroup(groupId);
	}
	@GetMapping("/total")
	public Double totalExpense() {

	    List<Expense> expenses =
	            expenseservice.getExpensesByGroup(5L);

	    double total = 0;

	    for(Expense e : expenses) {
	        total += e.getAmount();
	    }

	    return total;
	}
	@DeleteMapping("/delete")
	public String deleteExpense(
	        @RequestParam Long expenseId) {

	    expenseservice.deleteExpense(expenseId);

	    return "Expense Deleted Successfully";
	}
}
