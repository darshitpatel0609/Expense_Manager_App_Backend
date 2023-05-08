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

import com.Entity.ManageCategoryEntity;
import com.Repository.ManageCategoryRepository;

@CrossOrigin
@RestController
public class ManageCategoryController {

	@Autowired
	ManageCategoryRepository manageCategoryRepo;

	@PostMapping("/addCategory")
	public ManageCategoryEntity addCategory(@RequestBody ManageCategoryEntity categoruEntity) {
		return manageCategoryRepo.save(categoruEntity);
	}

	@GetMapping("/categories")
	public List<ManageCategoryEntity> getAllCategory() {
		return manageCategoryRepo.findAll();
	}

	@GetMapping("/category/byId/{categoryId}")
	public ManageCategoryEntity categoryById(@PathVariable("categoryId") Integer categortId) {
		Optional<ManageCategoryEntity> optCategory = manageCategoryRepo.findById(categortId);
		if (optCategory.isEmpty()) {
			return null;
		} else {
			return optCategory.get();
		}
	}

	@GetMapping("/category/byName/{categoryName}")
	public List<ManageCategoryEntity> getAllCategoryName(@PathVariable("categoryName") String categoryName) {
		return manageCategoryRepo.findByCategoryName(categoryName);
	}

	@DeleteMapping("/category/byId/{categoryId}")
	public ManageCategoryEntity deleteCategoryById(@PathVariable("categoryId") Integer categortId) {
		ManageCategoryEntity entity = manageCategoryRepo.findById(categortId).get();
		manageCategoryRepo.deleteById(categortId);
		return entity;
	}

	@PutMapping("/updateCategory")
	public ManageCategoryEntity updateCategory(@RequestBody ManageCategoryEntity entity) {
		manageCategoryRepo.save(entity);
		return entity;
	}

//	@PutMapping("/category/{categoryIdd}")
//	public ResponseEntity<ManageCategoryEntity> updateCategory(@PathVariable("categoryId") Integer categoryId,
//			@RequestBody ManageCategoryEntity categoryDetails) {
//		ManageCategoryEntity entity = manageCategoryRepo.findById(categoryId)
//				.orElseThrow(() -> new ResourceNotFoundException("Category not exist with categoryId :" + categoryId));
//
//		entity.setCategoryName(categoryDetails.getCategoryName());
//		entity.setCategoryId(categoryDetails.getCategoryId());
//
//		ManageCategoryEntity updatedCategory = manageCategoryRepo.save(entity);
//		return ResponseEntity.ok(updatedCategory);
//	}

}
