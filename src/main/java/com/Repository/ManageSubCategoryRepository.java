package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.ManageSubCategoryEntity;

@Repository
public interface ManageSubCategoryRepository extends CrudRepository<ManageSubCategoryEntity, Integer> {

	List<ManageSubCategoryEntity> findAll();

	List<ManageSubCategoryEntity> findBySubCategoryName(String subCategoryName);

}
