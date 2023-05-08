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

import com.Entity.ManageSubCategoryEntity;
import com.Repository.ManageSubCategoryRepository;

@CrossOrigin
@RestController
public class ManageSubCategoryController {

	@Autowired
	ManageSubCategoryRepository manageSubCategoryRepo;

	@PostMapping("/addSubCategory")
	public ManageSubCategoryEntity addSubCategory(@RequestBody ManageSubCategoryEntity subCategoruEntity) {
		return manageSubCategoryRepo.save(subCategoruEntity);
	}

	@GetMapping("/subCategories")
	public List<ManageSubCategoryEntity> getAllCategory() {
		return manageSubCategoryRepo.findAll();
	}

	@GetMapping("/subcategory/byId/{subCategoryId}")
	public ManageSubCategoryEntity subCategoryById(@PathVariable("subCategoryId") Integer subCategoryId) {
		Optional<ManageSubCategoryEntity> optCategory = manageSubCategoryRepo.findById(subCategoryId);
		if (optCategory.isEmpty()) {
			return null;
		} else {
			return optCategory.get();
		}
	}

	@GetMapping("/subcategory/byName/{subCategoryName}")
	public List<ManageSubCategoryEntity> getAllSubCategoryName(
			@PathVariable("subCategoryName") String subCategoryName) {
		return manageSubCategoryRepo.findBySubCategoryName(subCategoryName);
	}

	@DeleteMapping("/subcategory/byId/{subCategoryId}")
	public ManageSubCategoryEntity deleteSubCategoryById(@PathVariable("subCategoryId") Integer subCategoryId) {
		ManageSubCategoryEntity entity = manageSubCategoryRepo.findById(subCategoryId).get();
		manageSubCategoryRepo.deleteById(subCategoryId);
		return entity;
	}

	@PutMapping("/updateSubCategory")
	public ManageSubCategoryEntity updateSubCategory(@RequestBody ManageSubCategoryEntity entity) {
		manageSubCategoryRepo.save(entity);
		return entity;
	}

}
