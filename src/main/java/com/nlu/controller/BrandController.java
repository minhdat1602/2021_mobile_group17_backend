package com.nlu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.entity.BrandEntity;
import com.nlu.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	private BrandService brandService;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<BrandEntity> brands = brandService.getAll();
		return ResponseEntity.ok(brands);
	}
}
