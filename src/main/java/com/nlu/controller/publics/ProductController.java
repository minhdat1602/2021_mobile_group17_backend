package com.nlu.controller.publics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.ProductDTO;
import com.nlu.entity.ProductEntity;
import com.nlu.service.Impl.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductServiceImpl productService;

	@GetMapping("/all")
	public ResponseEntity<List<ProductEntity>> getAll() {
		List<ProductEntity> products = productService.getAll();
		System.out.print("getAll: " + products.size());

		return ResponseEntity.ok(products);
	}

	@GetMapping("/new")
	public ResponseEntity<List<ProductEntity>> getNew() {
		List<ProductEntity> products = productService.getNew();
		System.out.print("getNew: " + products.size());

		return ResponseEntity.ok(products);
	}

	@GetMapping("/hot")
	public ResponseEntity<List<ProductEntity>> getHot() {
		List<ProductEntity> products = productService.getHot();
		System.out.print("gethot: " + products.size());

		return ResponseEntity.ok(products);
	}

	@GetMapping("/highligh")
	public ResponseEntity<List<ProductEntity>> getHighligh() {
		List<ProductEntity> products = productService.getHighligh();
		System.out.print("gethot: " + products.size());

		return ResponseEntity.ok(products);
	}

	@GetMapping("/discount")
	public ResponseEntity<List<ProductEntity>> getDiscount() {
		List<ProductEntity> products = productService.getDiscount();
		System.out.print("getDiscount: " + products.size());

		return ResponseEntity.ok(products);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable("id") Long id) {
		ProductDTO product = productService.findById(id);
		return ResponseEntity.ok(product);
	}

	@GetMapping("/collection/{id}")
	public ResponseEntity<?> getProductByCollectionId(@PathVariable("id") long collectionId) {
		List<ProductEntity> products = productService.getByCollectionId(collectionId);
		System.out.print("getProductByCollectionId: " + products.size());
		return ResponseEntity.ok(products);
	}

	@GetMapping("/brand/{id}")
	public ResponseEntity<?> getProductByBrandId(@PathVariable("id") long brandId) {
		List<ProductEntity> products = productService.getByCollectionBrandId(brandId);
		System.out.print("getProductByBrandId: " + products.size());
		return ResponseEntity.ok(products);
	}

	@GetMapping("/category/{id}")
	public ResponseEntity<?> getProductByCategoryId(@PathVariable("id") long categoryId) {
		List<ProductEntity> products = productService.getByCategoryId(categoryId);
		System.out.print("getProductByCategoryId: " + products.size());
		return ResponseEntity.ok(products);
	}

	@GetMapping("/type/{id}")
	public ResponseEntity<?> getByTypeId(@PathVariable("id") long typeId) {
		List<ProductEntity> products = productService.getByCategoryId(typeId);
		System.out.print("getByTypeId: " + products.size());
		return ResponseEntity.ok(products);
	}

	@GetMapping("/category/{category_id}/type/{type_id}")
	public ResponseEntity<?> getByCategoryAndType(@PathVariable("category_id") long categoryId,
			@PathVariable("type_id") long typeId) {
		List<ProductEntity> products = productService.getByCategoryIdAndTypeId(categoryId, typeId);
		System.out.print("getByCategoryAndType: " + products.size());
		return ResponseEntity.ok(products);
	}

}
