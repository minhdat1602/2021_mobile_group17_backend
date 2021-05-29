package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.CategoryEntity;
import com.nlu.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	public List<CategoryEntity> getAll(){
		List<CategoryEntity> categories = categoryRepository.findAll();
		return categories;
	}
}
