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

import com.Dao.UserDaoImpl;
import com.Entity.UserCategoryEntity;
import com.Entity.UserSubCategoryEntity;
import com.Repository.UserCategoryRepository;
import com.Repository.UserSubCategoryRepository;
import com.bean.ResponseBean;

@CrossOrigin
@RestController
public class UserSubCategoryController {

	@Autowired
	UserSubCategoryRepository userSubCategoryRepository;

	@Autowired
	UserCategoryRepository userCategoryRepository;
	

	@Autowired
	UserDaoImpl ud;

	@PostMapping("/addUserSubCategory")
	public UserSubCategoryEntity addSubCategory(@RequestBody UserSubCategoryEntity userSubCategoruEntity) {
		return userSubCategoryRepository.save(userSubCategoruEntity);
	}

	@GetMapping("/userSubCategories")
	public List<UserSubCategoryEntity> getAllUserCategory() {
		return userSubCategoryRepository.findAll();
	}

	@GetMapping("/userSubcategory/byId/{userSubCategoryId}")
	public UserSubCategoryEntity userSubCategoryById(@PathVariable("userSubCategoryId") Integer userSubCategoryId) {
		Optional<UserSubCategoryEntity> optCategory = userSubCategoryRepository.findById(userSubCategoryId);
		if (optCategory.isEmpty()) {
			return null;
		} else {
			return optCategory.get();
		}
	}

	@GetMapping("/userSubcategory/byName/{userSubCategoryName}")
	public List<UserSubCategoryEntity> getAllUserSubCategoryName(
			@PathVariable("userSubCategoryName") String userSubCategoryName) {
		return userSubCategoryRepository.findByUserSubCategoryName(userSubCategoryName);
	}

	@DeleteMapping("/userSubcategory/byId/{userSubCategoryId}")
	public UserSubCategoryEntity deleteUserSubCategoryById(
			@PathVariable("userSubCategoryId") Integer userSubCategoryId) {
		UserSubCategoryEntity entity = userSubCategoryRepository.findById(userSubCategoryId).get();
		userSubCategoryRepository.deleteById(userSubCategoryId);
		return entity;
	}

	@PutMapping("/updateUserSubCategory")
	public UserSubCategoryEntity updateUserSubCategory(@RequestBody UserSubCategoryEntity entity) {
		userSubCategoryRepository.save(entity);
		return entity;
	}

}
