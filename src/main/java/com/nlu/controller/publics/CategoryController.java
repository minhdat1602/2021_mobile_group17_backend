package com.nlu.controller.publics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.CategoryDto;
import com.nlu.service.Impl.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	private final CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<CategoryDto> categories = this.categoryService.getAll();
		return ResponseEntity.ok(categories);
	}
}
