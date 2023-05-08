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

import com.Entity.UserAccountTypeEntity;
import com.Repository.UserAccountTypeRepository;

@CrossOrigin
@RestController
public class UserAccountTypeController {

	@Autowired
	UserAccountTypeRepository userAccountTypeRepository;

	@PostMapping("/addUserAccount")
	public UserAccountTypeEntity addAccount(@RequestBody UserAccountTypeEntity account) {
		return userAccountTypeRepository.save(account);
	}

	@GetMapping("/userAccounts")
	public List<UserAccountTypeEntity> getUserAccounts() {
		return userAccountTypeRepository.findAll();
	}

	@GetMapping("/userAccount/byId/{userAccountId}")
	public UserAccountTypeEntity getAccountById(@PathVariable("userAccountId") Integer userAccountId) {
		Optional<UserAccountTypeEntity> optAccount = userAccountTypeRepository.findById(userAccountId);
		if (optAccount.isEmpty()) {
			return null;
		} else {
			return optAccount.get();
		}
	}

	@GetMapping("/userAccount/byName/{accountName}")
	public List<UserAccountTypeEntity> getAccountByName(@PathVariable("accountName") String accountName) {
		return userAccountTypeRepository.findByAccountName(accountName);
	}

	@DeleteMapping("/userAccount/byId/{userAccountId}")
	public UserAccountTypeEntity deleteAccountById(@PathVariable("userAccountId") Integer userAccountId) {
		UserAccountTypeEntity entity = userAccountTypeRepository.findById(userAccountId).get();
		userAccountTypeRepository.deleteById(userAccountId);
		return entity;
	}

	@PutMapping("/updateUserAccount")
	public UserAccountTypeEntity updateAccount(@RequestBody UserAccountTypeEntity entity) {
		userAccountTypeRepository.save(entity);
		return entity;
	}

}
