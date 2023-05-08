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

import com.Entity.UserExpenseEntity;
import com.Repository.UserExpenseRepository;

@CrossOrigin
@RestController
public class UserExpenseController {

	@Autowired
	UserExpenseRepository userExpenseRepository;

	@PostMapping("/addUserExpense")
	public UserExpenseEntity addUserExpense(@RequestBody UserExpenseEntity expense) {
		return userExpenseRepository.save(expense);
	}

	@GetMapping("/userExpenses")
	public List<UserExpenseEntity> getAllUserExpense() {
		return userExpenseRepository.findAll();
	}

	@GetMapping("/userExpense/byId/{userExpenseId}")
	public UserExpenseEntity userExpenseById(@PathVariable("userExpenseId") Integer userExpenseId) {
		Optional<UserExpenseEntity> optExpense = userExpenseRepository.findById(userExpenseId);
		if (optExpense.isEmpty()) {
			return null;
		} else {
			return optExpense.get();
		}
	}

	@DeleteMapping("/userExpense/byId/{userExpenseId}")
	public UserExpenseEntity deleteExpenseById(@PathVariable("userExpenseId") Integer userExpenseId) {
		UserExpenseEntity entity = userExpenseRepository.findById(userExpenseId).get();
		userExpenseRepository.deleteById(userExpenseId);
		return entity;
	}

	@PutMapping("/updateUserExpense")
	public UserExpenseEntity updateExpense(@RequestBody UserExpenseEntity entity) {
		userExpenseRepository.save(entity);
		return entity;
	}
}
