package com.nlu.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.CategoryDto;
import com.nlu.entity.CategoryEntity;
import com.nlu.repository.CategoryRepository;

@Service
public class CategoryService {

	
	private final CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	@Autowired
	private ModelMapper mapper;

	public List<CategoryDto> getAll() {
		return categoryRepository
				.findAll()
				.stream()
				.map((category) -> mapper.map(category,CategoryDto.class))
				.collect(Collectors.toList());
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
