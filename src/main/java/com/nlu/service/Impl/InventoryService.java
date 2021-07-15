package com.nlu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.InventoryEntity;
import com.nlu.repository.InventoryRepository;

@Service
public class InventoryService {
	@Autowired
	private InventoryRepository inventoryRepository;

	public List<InventoryEntity> getAll() {
		List<InventoryEntity> inventories = inventoryRepository.findAll();
		return inventories;
	}

	public InventoryEntity getById(long id) {
		InventoryEntity inventory = inventoryRepository.findById(id);
		return inventory;
	}

	public InventoryEntity insert(InventoryEntity inventoryEntity) {
		InventoryEntity inventory = inventoryRepository.save(inventoryEntity);
		return inventory;
	}

	public InventoryEntity update(InventoryEntity inventoryEntity) {
		InventoryEntity inventory = inventoryRepository.save(inventoryEntity);
		return inventory;
	}

	public void delete(long id) {
		inventoryRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			inventoryRepository.deleteById(id);
	}
}
