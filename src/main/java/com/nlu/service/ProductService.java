package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.ProductEntity;
import com.nlu.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<ProductEntity> findAll(){
		return productRepository.findAll();
	}
	
}
