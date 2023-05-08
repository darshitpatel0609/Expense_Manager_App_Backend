package com.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Entity.ManageVendorEntity;

@Repository
public interface ManageVendorRepository extends CrudRepository<ManageVendorEntity, Integer> {

	List<ManageVendorEntity> findAll();

	ManageVendorEntity findByVendorName(String vendorName);

}
