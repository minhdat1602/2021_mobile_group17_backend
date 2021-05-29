package com.nlu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.entity.SizeEntity;
import com.nlu.service.SizeService;

@RestController
@RequestMapping("/api/size")
public class SizeController {

	@Autowired
	private SizeService sizeService;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<SizeEntity> sizes = sizeService.getAll();
		return ResponseEntity.ok(sizes);
	}
}
