package com.nlu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.entity.ColorEntity;
import com.nlu.service.ColorService;

@RestController
@RequestMapping("/api/color")
public class ColorController {

	@Autowired
	private ColorService colorService;

	@GetMapping("/all")
	public ResponseEntity<?> getAll() {
		List<ColorEntity> colors = colorService.getAll();
		return ResponseEntity.ok(colors);
	}
}
