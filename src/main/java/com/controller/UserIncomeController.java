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

import com.Entity.UserIncomeEntity;
import com.Repository.UserIncomeRepository;

@CrossOrigin
@RestController
public class UserIncomeController {

	@Autowired
	UserIncomeRepository userIncomeRepository;

	@PostMapping("/addUserIncome")
	public UserIncomeEntity addIncome(@RequestBody UserIncomeEntity entity) {
		return userIncomeRepository.save(entity);
	}

	@GetMapping("/userIncomes")
	public List<UserIncomeEntity> getIncome() {
		return userIncomeRepository.findAll();
	}

	@GetMapping("/userIncome/byId/{userIncomeId}")
	public UserIncomeEntity getIncomeById(@PathVariable("userIncomeId") Integer userIncomeId) {
		Optional<UserIncomeEntity> optIncome = userIncomeRepository.findById(userIncomeId);
		if (optIncome.isEmpty()) {
			return null;
		} else {
			return optIncome.get();
		}
	}

	@DeleteMapping("/userIncome/byId/{userIncomeId}")
	public UserIncomeEntity deleteIncomeById(@PathVariable("userIncomeId") Integer userIncomeId) {
		UserIncomeEntity entity = userIncomeRepository.findById(userIncomeId).get();
		userIncomeRepository.deleteById(userIncomeId);
		return entity;
	}

	@PutMapping("/updateUserIncome")
	public UserIncomeEntity updateAccount(@RequestBody UserIncomeEntity entity) {
		userIncomeRepository.save(entity);
		return entity;
	}

}
