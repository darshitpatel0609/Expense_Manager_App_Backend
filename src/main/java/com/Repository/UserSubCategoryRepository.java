package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.UserSubCategoryEntity;

@Repository
public interface UserSubCategoryRepository extends CrudRepository<UserSubCategoryEntity, Integer> {

	List<UserSubCategoryEntity> findAll();

	List<UserSubCategoryEntity> findByUserSubCategoryName(String userSubCategoryName);

//	UserSubCategoryEntity findBySubCategoryNameAndUserCategoryId(String userSubCategoryName, Integer userCategoryId);
//
//	List<UserSubCategoryEntity> getUserSubCategoryById(int userSubCategoryId);

}

