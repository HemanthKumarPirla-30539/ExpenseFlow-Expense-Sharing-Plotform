package com.example.Splimate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

	@Autowired
	ExpenseRepository expenserepository;
	
	@Autowired
	MemberRepository memberrepository;
	
	@Autowired
	GroupRepository grouprepository;
	
	public Expense addExpense(Expense expense,
								Long memberId,
								Long groupId) {
		Member member=memberrepository.findById(memberId)
				.orElseThrow(() ->
                new RuntimeException("Member Not Found"));
                
                
          GroupEntity group=grouprepository.findById(groupId)
        		  .orElseThrow(()->
        		  new RuntimeException("Group Not Found"));
          
          expense.setPaidBy(member);
          expense.setGroup(group);
                return expenserepository.save(expense);
	}
	public List<Expense> getExpensesByGroup(Long groupId){
		return expenserepository.findByGroupId(groupId);
	}
	public void deleteExpense(Long expenseId) {

	    expenserepository.deleteById(expenseId);

	}
	
}
