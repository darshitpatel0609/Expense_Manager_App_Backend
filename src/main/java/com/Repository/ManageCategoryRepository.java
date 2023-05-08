package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.ManageCategoryEntity;

@Repository
public interface ManageCategoryRepository extends CrudRepository<ManageCategoryEntity, Integer> {

	List<ManageCategoryEntity> findAll();

	List<ManageCategoryEntity> findByCategoryName(String categoryName);

}
