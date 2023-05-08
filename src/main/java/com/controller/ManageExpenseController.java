package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.ManageExpenseEntity;
import com.Repository.ManageExpenseRepository;

@CrossOrigin
@RestController
public class ManageExpenseController {

	@Autowired
	ManageExpenseRepository manageExpenseRepository;

	@PostMapping("/addExpense")
	public ManageExpenseEntity addExpense(@RequestBody ManageExpenseEntity expense) {
		return manageExpenseRepository.save(expense);
	}

	@GetMapping("/expenses")
	public List<ManageExpenseEntity> getAllExpense() {
		return manageExpenseRepository.findAll();
	}

	@GetMapping("/expense/byId/{expenseId}")
	public ManageExpenseEntity expenseById(@PathVariable("expenseId") Integer expenseId) {
		Optional<ManageExpenseEntity> optExpense = manageExpenseRepository.findById(expenseId);
		if (optExpense.isEmpty()) {
			return null;
		} else {
			return optExpense.get();
		}
	}

	@DeleteMapping("/expense/byId/{expenseId}")
	public ManageExpenseEntity deleteExpenseById(@PathVariable("expenseId") Integer expenseId) {
		ManageExpenseEntity entity = manageExpenseRepository.findById(expenseId).get();
		manageExpenseRepository.deleteById(expenseId);
		return entity;
	}

	@PutMapping("/updateExpense")
	public ManageExpenseEntity updateExpense(@RequestBody ManageExpenseEntity entity) {
		manageExpenseRepository.save(entity);
		return entity;
	}
}
