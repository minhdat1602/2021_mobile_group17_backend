package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.SupplierEntity;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {
	List<SupplierEntity> findAll();

	SupplierEntity findById(long id);

	<S extends SupplierEntity> S save(S entity);

	void delete(SupplierEntity supplierEntity);
}
