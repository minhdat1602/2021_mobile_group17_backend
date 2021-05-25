package com.nlu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.entity.ProductEntity;
import com.nlu.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ShopController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductEntity>> getAll(){
		List<ProductEntity> products = productService.findAll();
		System.out.print("product num: " + products.size());
		return ResponseEntity.ok(products);
	}
	
}
