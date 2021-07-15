package com.nlu.controller.publics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.entity.CollectionEntity;
import com.nlu.service.Impl.CollectionService;

@RestController
@RequestMapping("/collection")
public class CollectionController {

	@Autowired
	private CollectionService collectionService;

	@GetMapping("/brand/{id}")
	public ResponseEntity<?> getByBrandId(@PathVariable("id") long brandId) {
		List<CollectionEntity> collections = collectionService.getByBrand(brandId);
		return ResponseEntity.ok(collections);
	}
}
