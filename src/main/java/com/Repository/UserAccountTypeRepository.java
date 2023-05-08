package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.AccountTypeEntity;
import com.Entity.UserAccountTypeEntity;

@Repository
public interface UserAccountTypeRepository extends CrudRepository<UserAccountTypeEntity, Integer> {

	List<UserAccountTypeEntity> findAll();

	List<UserAccountTypeEntity> findByAccountName(String accountName);

}
