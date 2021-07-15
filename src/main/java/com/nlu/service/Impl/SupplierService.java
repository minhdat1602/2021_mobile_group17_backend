package com.nlu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.SupplierEntity;
import com.nlu.repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;

	public List<SupplierEntity> getAll() {
		List<SupplierEntity> suppliers = supplierRepository.findAll();
		return suppliers;
	}

	public SupplierEntity getById(long id) {
		SupplierEntity supplier = supplierRepository.findById(id);
		return supplier;
	}

	public SupplierEntity insert(SupplierEntity supplierEntity) {
		SupplierEntity supplier = supplierRepository.save(supplierEntity);
		return supplier;
	}

	public SupplierEntity update(SupplierEntity supplierEntity) {
		SupplierEntity supplier = supplierRepository.save(supplierEntity);
		return supplier;
	}

	public void delete(long id) {
		supplierRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			supplierRepository.deleteById(id);
	}
}
