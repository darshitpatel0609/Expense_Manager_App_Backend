package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.ManageUserEntity;

@Repository
public interface ManageUserRepository extends CrudRepository<ManageUserEntity, Integer> {

	List<ManageUserEntity> findAll();

	List<ManageUserEntity> findByFirstName(String firstName);

}
