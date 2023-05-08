package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.UserCategoryEntity;
import com.Entity.UserEntity;
import com.Repository.UserCategoryRepository;
import com.Repository.UserSingUpRepository;
import com.Repository.UserSubCategoryRepository;
import com.bean.ResponseBean;

@CrossOrigin
@RestController
public class UserCategoryController {

	@Autowired
	UserCategoryRepository userCategoryRepository;

	@Autowired
	UserSubCategoryRepository userSubCategoryRepository;

	@Autowired
	UserSingUpRepository userSingUpRepository;

	@PostMapping("/addUserCategory")
	public UserCategoryEntity addUserCategory(@RequestBody UserCategoryEntity userCategoruEntity) {
		return userCategoryRepository.save(userCategoruEntity);
	}

	@GetMapping("/userCategories")
	public List<UserCategoryEntity> getAllCategory() {
		return userCategoryRepository.findAll();
	}

	@GetMapping("/userCategory/byId/{userCategoryId}")
	public UserCategoryEntity useCategoryById(@PathVariable("userCategoryId") Integer userCategoryId) {
		Optional<UserCategoryEntity> optCategory = userCategoryRepository.findById(userCategoryId);
		if (optCategory.isEmpty()) {
			return null;
		} else {
			return optCategory.get();
		}
	}

	@GetMapping("/userCategory/byName/{userCategoryName}")
	public List<UserCategoryEntity> getAllUserCategoryName(@PathVariable("userCategoryName") String userCategoryName) {
		return userCategoryRepository.findByUserCategoryName(userCategoryName);
	}

	@DeleteMapping("/userCategory/byId/{userCategoryId}")
	public UserCategoryEntity deleteUserCategoryById(@PathVariable("userCategoryId") Integer userCategoryId) {
		UserCategoryEntity entity = userCategoryRepository.findById(userCategoryId).get();
		userCategoryRepository.deleteById(userCategoryId);
		return entity;
	}

	@PutMapping("/updateUserCategory")
	public UserCategoryEntity updateUserCategory(@RequestBody UserCategoryEntity entity) {
		userCategoryRepository.save(entity);
		return entity;
	}

}
