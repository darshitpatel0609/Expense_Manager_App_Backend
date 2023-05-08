package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.UserExpenseEntity;

@Repository
public interface UserExpenseRepository extends CrudRepository<UserExpenseEntity, Integer> {

	List<UserExpenseEntity> findAll();

}
