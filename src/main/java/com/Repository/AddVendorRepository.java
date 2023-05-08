package com.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.AddVendorEntity;

@Repository
public interface AddVendorRepository extends CrudRepository<AddVendorEntity, Integer> {

	List<AddVendorEntity> findAll();

	AddVendorEntity findByUserVendorName(String userVendorName);

//	AddVendorEntity findByUserUserIdAndUserVendorName(Integer userId, String userVendorName);
//
//	List<AddVendorEntity> findByUserVendorId(Integer userVendorId);

}
