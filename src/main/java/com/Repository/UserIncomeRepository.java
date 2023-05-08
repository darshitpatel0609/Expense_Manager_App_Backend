package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.UserIncomeEntity;

@Repository
public interface UserIncomeRepository extends CrudRepository<UserIncomeEntity, Integer> {

	List<UserIncomeEntity> findAll();

}
