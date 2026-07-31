package com.example.Splimate;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;

public interface ExpenseRepository extends JpaRepository<Expense,Long>{
	public List<Expense> findByGroupId(Long groupId);

	@Transactional
	void deleteByGroupId(Long groupId);
}
