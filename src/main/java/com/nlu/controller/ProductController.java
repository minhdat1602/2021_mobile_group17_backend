package com.nlu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.entity.ProductEntity;
import com.nlu.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/all")
	public ResponseEntity<List<ProductEntity>> getAll() {
		List<ProductEntity> products = productService.getAll();
		System.out.print("product num: " + products.size());
		
		return ResponseEntity.ok(products);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductEntity> getProductById(@PathVariable("id") long id) {
		ProductEntity product = productService.getById(id);
		System.out.print(product.toString());
		return ResponseEntity.ok(product);
	}
	
	@GetMapping("/collection/{id}")
	public ResponseEntity<?> getProductByCollectionId(@PathVariable("id") long collectionId) {
		List<ProductEntity> products = productService.getByCollectionId(collectionId);
		return ResponseEntity.ok(products);
	}

	@GetMapping("/brand/{id}")
	public ResponseEntity<?> getProductByBrandId(@PathVariable("id") long brandId) {
		List<ProductEntity> products = productService.getByCollectionBrandId(brandId);
		return ResponseEntity.ok(products);
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<?> getProductByCategoryId(@PathVariable("id") long categoryId) {
		List<ProductEntity> products = productService.getByCategoryId(categoryId);
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/type/{id}")
	public ResponseEntity<?> getByTypeId(@PathVariable("id") long typeId) {
		List<ProductEntity> products = productService.getByCategoryId(typeId);
		return ResponseEntity.ok(products);
	}
	
	@GetMapping("/category/{category_id}/type/{type_id}")
	public ResponseEntity<?> getByCategoryAndType(@PathVariable("category_id") long categoryId,
													@PathVariable("type_id") long typeId) {
		List<ProductEntity> products = productService.getByCategoryIdAndTypeId(categoryId, typeId);
		return ResponseEntity.ok(products);
	}

}
