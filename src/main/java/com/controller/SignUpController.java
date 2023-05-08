package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.UserEntity;
import com.Repository.UserSingUpRepository;
import com.bean.ResponseBean;
import com.service.TokenGenerator;

@CrossOrigin
@RestController
public class SignUpController {

	@Autowired
	UserSingUpRepository userRepo;

	@Autowired
	TokenGenerator tokenGenerator;

	@PostMapping("/addUser")
	public ResponseEntity<ResponseBean<UserEntity>> addUser(@RequestBody UserEntity userEntity) {
		UserEntity existingUser = userRepo.findByEmail(userEntity.getEmail());

		ResponseBean<UserEntity> resp = new ResponseBean<>();

		if (existingUser == null && userEntity.getEmail() != null) {
			userRepo.save(userEntity);

			resp.setData(userEntity);
			resp.setMsg("User Registered Successful..!");

			return ResponseEntity.ok(resp);
		} else {
			resp.setData(userEntity);
			resp.setMsg("Please Enter Unique Email..!");
			return new ResponseEntity<ResponseBean<UserEntity>>(resp, HttpStatus.UNPROCESSABLE_ENTITY);
		}

	}

	@GetMapping("/users")
	public List<UserEntity> getAllUser() {
		return userRepo.findAll();
	}

	@GetMapping("/user/byId/{userId}")
	public UserEntity getuserById(@PathVariable("userId") Integer userId) {
		Optional<UserEntity> optUser = userRepo.findById(userId);
		if (optUser.isEmpty()) {
			return null;
		} else {
			return optUser.get();
		}
	}

	@GetMapping("/user/byName/{firstName}")
	public List<UserEntity> userByFirstName(@PathVariable("firstName") String firstName) {
		return userRepo.findByFirstName(firstName);
	}

	@DeleteMapping("/user/byId/{userId}")
	public UserEntity getDeleteById(@PathVariable("userId") Integer userId) {
		UserEntity user = userRepo.findById(userId).get();
		userRepo.deleteById(userId);
		return user;
	}

	@PutMapping("/updateuser")
	public UserEntity updateuser(@RequestBody UserEntity user) {
		userRepo.save(user);
		return user;
	}

	@PostMapping("/Login")
	public ResponseEntity<ResponseBean<UserEntity>> loginUser(@RequestBody UserEntity userEntity) {

		UserEntity dbUser = userRepo.getByEmail(userEntity.getEmail());
		ResponseBean<UserEntity> res = new ResponseBean<>();
		boolean isRight = false;
		if (dbUser != null) {
			if (userEntity.getPassword().matches(dbUser.getPassword())) {
				isRight = true;
				String token = tokenGenerator.generateToken(16);
				dbUser.setToken(token);
				userRepo.save(dbUser);
				res.setData(dbUser);
				res.setMsg("User Login successful");
			} else {
				res.setMsg("password is not	 metched.");
			}
		}
		return ResponseEntity.ok(res);
	}

	@GetMapping("/forgotPassword")
	public ResponseEntity<ResponseBean<UserEntity>> forgotPasseord(@RequestParam("email") String email) {
		UserEntity tempUserByEmail = userRepo.findByEmail(email);
		ResponseBean<UserEntity> usr = new ResponseBean<>();
		if (tempUserByEmail == null) {
			usr.setData(null);
			usr.setMsg("Otp will share to your Email, if email is exists !!");
			return ResponseEntity.ok(usr);
		} else {
			Integer min = 100000;
			Integer max = 999999;
			Integer temp = (int) (Math.random() * (max - min + 1) + min);
			System.out.println("-----------------" + temp + "-----------------");
			tempUserByEmail.setOtp(temp);
			userRepo.save(tempUserByEmail);
			usr.setData(tempUserByEmail);
			usr.setMsg("Otp will share to your Email, if email is exists (OTP set)!!");
			return ResponseEntity.ok(usr);
		}
	}

	@GetMapping("/ResetPassword")
	public ResponseEntity<ResponseBean<UserEntity>> resetPassword(@RequestParam("otp") Integer otp,
			@RequestParam("password") String password, @RequestParam("conformpassword") String conformpassword) {
		UserEntity user = userRepo.findByOtp(otp);
		if ((password.equals(conformpassword)) && !(user.getPassword().equals(password))) {
			ResponseBean<UserEntity> usr = new ResponseBean<>();
			user.setPassword(conformpassword);
			userRepo.save(user);
			usr.setData(user);
			usr.setMsg("Password sucessfully reset !!");
			return ResponseEntity.ok(usr);
		} else {
			ResponseBean<UserEntity> usr = new ResponseBean<>();
			usr.setData(null);
			usr.setMsg("Please enter password and conformpassword same !!");
			return ResponseEntity.ok(usr);
		}
	}

}
