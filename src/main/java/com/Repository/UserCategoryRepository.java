package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.UserCategoryEntity;

@Repository
public interface UserCategoryRepository extends CrudRepository<UserCategoryEntity, Integer> {

	List<UserCategoryEntity> findAll();

	List<UserCategoryEntity> findByUserCategoryName(String userCategoryName);

	List<UserCategoryEntity> findByUserCategoryId(Integer userCategoryId);

//	UserCategoryEntity findByUserCategoryNameAndUserCategoryId(Integer userId);
//
//	UserCategoryEntity findByUserCategoryNameAndUserCategoryId(String userCategoryName, Integer userId);

}
