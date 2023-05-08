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

import com.Entity.ManageVendorEntity;
import com.Repository.ManageVendorRepository;

@CrossOrigin
@RestController
public class ManageVenderController {

	@Autowired
	ManageVendorRepository manageVendorRepository;

	@PostMapping("/addVendor")
	public ManageVendorEntity addVendor(@RequestBody ManageVendorEntity vendor) {
		return manageVendorRepository.save(vendor);
	}

	@GetMapping("/vendors")
	public List<ManageVendorEntity> getAllVendor() {
		return manageVendorRepository.findAll();
	}

	@GetMapping("/vendor/byId/{vendorId}")
	public ManageVendorEntity getVendorId(@PathVariable("vendorId") Integer vendorId) {
		Optional<ManageVendorEntity> optVendor = manageVendorRepository.findById(vendorId);
		if (optVendor.isEmpty()) {
			return null;
		} else {
			return optVendor.get();
		}
	}

	@GetMapping("vendor/byName/{vendorName}")
	public ManageVendorEntity getVendorName(@PathVariable("vendorName") String vendorName) {
		return manageVendorRepository.findByVendorName(vendorName);
	}

	@DeleteMapping("/vendor/byId/{vendorId}")
	public ManageVendorEntity deleterVendor(@PathVariable("vendorId") Integer vendorId) {
		ManageVendorEntity entity = manageVendorRepository.findById(vendorId).get();
		manageVendorRepository.deleteById(vendorId);
		return entity;
	}

	@PutMapping("updateVendor")
	public ManageVendorEntity updateVendor(@RequestBody ManageVendorEntity entity) {
		manageVendorRepository.save(entity);
		return entity;
	}

}
