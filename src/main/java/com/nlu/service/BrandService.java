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
}
