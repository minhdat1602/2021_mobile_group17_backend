package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.CollectionEntity;
import com.nlu.repository.CollectionRepository;

@Service
public class CollectionService {
	
	@Autowired
	private CollectionRepository collectionRepository;
	
	public List<CollectionEntity> getByBrand(long brandId){
		List<CollectionEntity> collections = collectionRepository.findByBrand(brandId);
		return collections;
	}
	
	public List<CollectionEntity> getAll() {
		List<CollectionEntity> categories = collectionRepository.findAll();
		return categories;
	}

	public CollectionEntity getById(long id) {
		CollectionEntity collection = collectionRepository.findById(id);
		return collection;
	}

	public CollectionEntity insert(CollectionEntity collectionEntity) {
		CollectionEntity collection = collectionRepository.save(collectionEntity);
		return collection;
	}

	public CollectionEntity update(CollectionEntity collectionEntity) {
		CollectionEntity collection = collectionRepository.save(collectionEntity);
		return collection;
	}

	public void delete(long id) {
		collectionRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			collectionRepository.deleteById(id);
	}
}
