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

import com.Entity.AccountTypeEntity;
import com.Repository.AccountTypeRepository;

@CrossOrigin
@RestController
public class AccountTypeController {

	@Autowired
	AccountTypeRepository accountTypeRepository;

	@PostMapping("/addAccount")
	public AccountTypeEntity addAccount(@RequestBody AccountTypeEntity account) {
		return accountTypeRepository.save(account);
	}

	@GetMapping("/accounts")
	public List<AccountTypeEntity> getAccounts() {
		return accountTypeRepository.findAll();
	}

	@GetMapping("/account/byId/{accountId}")
	public AccountTypeEntity getAccountById(@PathVariable("accountId") Integer accountId) {
		Optional<AccountTypeEntity> optAccount = accountTypeRepository.findById(accountId);
		if (optAccount.isEmpty()) {
			return null;
		} else {
			return optAccount.get();
		}
	}

	@GetMapping("/account/byName/{accountName}")
	public List<AccountTypeEntity> getAccountByName(@PathVariable("accountName") String accountName) {
		return accountTypeRepository.findByAccountName(accountName);
	}

	@DeleteMapping("/account/byId/{accountId}")
	public AccountTypeEntity deleteAccountById(@PathVariable("accountId") Integer accountId) {
		AccountTypeEntity entity = accountTypeRepository.findById(accountId).get();
		accountTypeRepository.deleteById(accountId);
		return entity;
	}

	@PutMapping("/updateAccount")
	public AccountTypeEntity updateAccount(@RequestBody AccountTypeEntity entity) {
		accountTypeRepository.save(entity);
		return entity;
	}

}
