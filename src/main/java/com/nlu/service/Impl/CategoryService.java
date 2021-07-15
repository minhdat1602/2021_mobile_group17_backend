package com.nlu.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.CategoryEntity;
import com.nlu.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public List<CategoryEntity> getAll() {
		List<CategoryEntity> categories = categoryRepository.findAll();
		return categories;
	}

	public CategoryEntity getById(long id) {
		CategoryEntity category = categoryRepository.findById(id);
		return category;
	}

	public CategoryEntity insert(CategoryEntity categoryEntity) {
		CategoryEntity category = categoryRepository.save(categoryEntity);
		return category;
	}

	public CategoryEntity update(CategoryEntity categoryEntity) {
		CategoryEntity category = categoryRepository.save(categoryEntity);
		return category;
	}

	public void delete(long id) {
		categoryRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			categoryRepository.deleteById(id);
	}
}
