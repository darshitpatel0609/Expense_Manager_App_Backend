package com.Dao;

import java.util.List;

import com.Entity.UserSubCategoryEntity;


public interface UserDao {

	List<UserSubCategoryEntity> searchCriteria(Integer id);

}
