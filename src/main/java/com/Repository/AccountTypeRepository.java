package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.AccountTypeEntity;

@Repository
public interface AccountTypeRepository extends CrudRepository<AccountTypeEntity, Integer> {

	List<AccountTypeEntity> findAll();

	List<AccountTypeEntity> findByAccountName(String accountName);

}
