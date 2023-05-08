package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.ManageExpenseEntity;

@Repository
public interface ManageExpenseRepository extends CrudRepository<ManageExpenseEntity, Integer> {

	List<ManageExpenseEntity> findAll();

}
