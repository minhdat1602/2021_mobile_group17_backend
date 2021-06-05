package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.BrandEntity;
import com.nlu.repository.BrandRepository;

@Service
public class BrandService {

	@Autowired
	private BrandRepository brandRepository;

	public List<BrandEntity> getAll() {
		List<BrandEntity> brands = brandRepository.findAll();
		return brands;
	}

	public BrandEntity getById(long id) {
		BrandEntity brand = brandRepository.findById(id);
		return brand;
	}

//	public BrandEntity create(BrandEntity brandEntity) {
//		BrandEntity brand = brandRepository.save(brandEntity);
//		return brand;
//	}
//
//	public BrandEntity update(BrandEntity brandEntity) {
//		if (brandRepository.existsById(brandEntity.getId())) {
//			return brandRepository.save(brandEntity);
//		} else
//			return null;
//	}

	public void delete(long id) {
		brandRepository.deleteById(id);
	}

	public void deleteAll(Long[] ids) {
		for (Long id : ids)
			brandRepository.deleteById(id);
	}

}
