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

import com.Entity.ManageUserEntity;
import com.Repository.ManageUserRepository;

@CrossOrigin
@RestController
public class ManageUserController {

	@Autowired
	ManageUserRepository userRepo;

	@PostMapping("/user")
	public ManageUserEntity addUser(@RequestBody ManageUserEntity userEntity) {
		return userRepo.save(userEntity);

	}

	@GetMapping("manageusers")
	public List<ManageUserEntity> getAllUser() {
		return userRepo.findAll();
	}

	@GetMapping("/user/byId/{manageUserId}")
	public ManageUserEntity userById(@PathVariable("manageUserId") Integer manageUserId) {
		Optional<ManageUserEntity> optCategory = userRepo.findById(manageUserId);
		if (optCategory.isEmpty()) {
			return null;
		} else {
			return optCategory.get();
		}
	}
//
//	@GetMapping("/user/byName/{firstName}")
//	public List<ManageUserEntity> userByFirstName(@PathVariable("firstName") String firstName) {
//		return userRepo.findByFirstName(firstName);
//	}

	@DeleteMapping("/byId/{manageUserId}")
	public ManageUserEntity getDeleteById(@PathVariable("manageUserId") Integer manageUserId) {
		ManageUserEntity user = userRepo.findById(manageUserId).get();
		userRepo.deleteById(manageUserId);
		return user;
	}

	@PutMapping("/updateUserManage")
	public ManageUserEntity updateuser(@RequestBody ManageUserEntity user) {
		userRepo.save(user);
		return user;
	}

}
