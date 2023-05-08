package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.IncomeEntity;

@Repository
public interface IncomeRepository extends CrudRepository<IncomeEntity, Integer> {

	List<IncomeEntity> findAll();

}
