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

import com.Entity.AddVendorEntity;
import com.Entity.UserEntity;
import com.Repository.AddVendorRepository;
import com.Repository.UserSingUpRepository;
import com.bean.ResponseBean;

@CrossOrigin
@RestController
public class AddVendorController {

	@Autowired
	AddVendorRepository addVendorRepository;

	@Autowired
	UserSingUpRepository userSingUpRepository;

	@PostMapping("/addUserVendor")
	public AddVendorEntity addUserVendor(@RequestBody AddVendorEntity vendor) {
		return addVendorRepository.save(vendor);
	}

	@GetMapping("/userVendors")
	public List<AddVendorEntity> getAllUserVendor() {
		return addVendorRepository.findAll();
	}

	@GetMapping("/addVendor/byId/{userVendorId}")
	public AddVendorEntity getUserVendorId(@PathVariable("userVendorId") Integer userVendorId) {
		Optional<AddVendorEntity> optVendor = addVendorRepository.findById(userVendorId);
		if (optVendor.isEmpty()) {
			return null;
		} else {
			return optVendor.get();
		}
	}

	@GetMapping("addVendor/byName/{userVendorName}")
	public AddVendorEntity getUserVendorName(@PathVariable("userVendorName") String userVendorName) {
		return addVendorRepository.findByUserVendorName(userVendorName);
	}

	@DeleteMapping("/userVendor/byId/{userVendorId}")
	public AddVendorEntity deleterUserVendor(@PathVariable("userVendorId") Integer userVendorId) {
		AddVendorEntity entity = addVendorRepository.findById(userVendorId).get();
		addVendorRepository.deleteById(userVendorId);
		return entity;
	}

	@PutMapping("updateUserVendor")
	public AddVendorEntity updateUserVendor(@RequestBody AddVendorEntity entity) {
		addVendorRepository.save(entity);
		return entity;
	}

}