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

import com.Entity.IncomeEntity;
import com.Repository.IncomeRepository;

@CrossOrigin
@RestController
public class IncomeController {

	@Autowired
	IncomeRepository incomeRepository;

	@PostMapping("/addIncome")
	public IncomeEntity addIncome(@RequestBody IncomeEntity entity) {
		return incomeRepository.save(entity);
	}

	@GetMapping("/incomes")
	public List<IncomeEntity> getIncome() {
		return incomeRepository.findAll();
	}

	@GetMapping("/income/byId/{incomeId}")
	public IncomeEntity getIncomeById(@PathVariable("incomeId") Integer incomeId) {
		Optional<IncomeEntity> optIncome = incomeRepository.findById(incomeId);
		if (optIncome.isEmpty()) {
			return null;
		} else {
			return optIncome.get();
		}
	}

	@DeleteMapping("/income/byId/{incomeId}")
	public IncomeEntity deleteIncomeById(@PathVariable("incomeId") Integer incomeId) {
		IncomeEntity entity = incomeRepository.findById(incomeId).get();
		incomeRepository.deleteById(incomeId);
		return entity;
	}

	@PutMapping("/updateIncome")
	public IncomeEntity updateAccount(@RequestBody IncomeEntity entity) {
		incomeRepository.save(entity);
		return entity;
	}

}
