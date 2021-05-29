package com.nlu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.entity.TypeEntity;
import com.nlu.service.TypeService;

@RestController
@RequestMapping("/api/type")
public class TypeController {

	@Autowired
	private TypeService typeService;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<TypeEntity> types = typeService.getAll();
		return ResponseEntity.ok(types);
	}
}
