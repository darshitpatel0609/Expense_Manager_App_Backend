package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.UserEntity;

@Repository
public interface UserSingUpRepository extends CrudRepository<UserEntity, Integer> {

	List<UserEntity> findAll();

	List<UserEntity> findByFirstName(String firstName);

	UserEntity getByEmail(String email);

	UserEntity findByEmail(String email);
	
	UserEntity findByOtp(Integer otp);
	
	Optional<UserEntity> findByToken(String token);

}
