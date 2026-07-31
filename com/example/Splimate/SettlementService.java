package com.example.Splimate;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettlementService {

	@Autowired
	public ExpenseRepository expenserepository;
	
	@Autowired
	public MemberRepository memberrepository;
	
	public String calculateSettlement(Long groupId) {

	    List<Expense> expense =
	            expenserepository.findByGroupId(groupId);

	    List<Member> members =
	            memberrepository.findByGroupentityId(groupId);

	    double totalExpenses = 0;

	    for (Expense exp : expense) {
	        totalExpenses += exp.getAmount();
	    }

	    double perHead =
	            totalExpenses / members.size();

	    Map<Long, Double> paidAmounts =
	            new HashMap<>();

	    for (Expense exp : expense) {

	        Long memberId =
	                exp.getPaidBy().getId();

	        double amount =
	                exp.getAmount();

	        paidAmounts.put(
	                memberId,
	                paidAmounts.getOrDefault(
	                        memberId, 0.0) + amount
	        );
	    }

	    Map<String, Double> debtors =
	            new HashMap<>();

	    Map<String, Double> creditors =
	            new HashMap<>();

	    String result = "";

	    result += "Total Expense = "
	            + totalExpenses + "\n";

	    result += "Per Head = "
	            + perHead + "\n\n";

	    for (Member member : members) {

	        double paid =
	                paidAmounts.getOrDefault(
	                        member.getId(), 0.0);

	        double balance =
	                paid - perHead;

	        if(balance < 0) {

	            result += "\n"
	                    + member.getMembername()
	                    + "\nPaid : ₹"
	                    + paid
	                    + "\nNeeds To Pay : ₹"
	                    + Math.abs(balance)
	                    + "\n";

	        }
	        else if(balance > 0) {

	            result += "\n"
	                    + member.getMembername()
	                    + "\nPaid : ₹"
	                    + paid
	                    + "\nShould Receive : ₹"
	                    + balance
	                    + "\n";

	        }
	        else {

	            result += "\n"
	                    + member.getMembername()
	                    + "\nSettled ✅\n";
	        }

	        if (balance < 0) {

	            debtors.put(
	                    member.getMembername(),
	                    Math.abs(balance));
	        }

	        else if (balance > 0) {

	            creditors.put(
	                    member.getMembername(),
	                    balance);
	        }
	    }

	    result += "\nSettlement:\n";

	    for (String debtor : debtors.keySet()) {

	        double amountToPay =
	                debtors.get(debtor);

	        for (String creditor :
	                creditors.keySet()) {

	            double amountToReceive =
	                    creditors.get(creditor);

	            if (amountToReceive > 0) {

	                double payment =
	                        Math.min(
	                                amountToPay,
	                                amountToReceive);

	                result += "\n"
	                        + debtor
	                        + " ➜ "
	                        + creditor
	                        + " : ₹"
	                        + payment
	                        + "\n";

	                amountToPay -= payment;

	                creditors.put(
	                        creditor,
	                        amountToReceive - payment);

	                if (amountToPay == 0) {
	                    break;
	                }
	            }
	        }
	    }

	    return result;
	}
}
