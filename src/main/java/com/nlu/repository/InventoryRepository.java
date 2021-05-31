package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.InventoryEntity;

@Repository
public interface InventoryRepository extends JpaRepository<InventoryEntity, Long>{
	List<InventoryEntity> findAll();

	InventoryEntity findById(long id);

	<S extends InventoryEntity> S save(S entity);

	void delete(InventoryEntity inventoryEntity);
}
