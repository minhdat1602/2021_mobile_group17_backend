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
}
