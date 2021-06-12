package com.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

//	@GetMapping("/all")
//	public ResponseEntity<?> getAll() {
//		return ResponseEntity.ok(userService.getAll());
//	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") long userId) {
		return ResponseEntity.ok(userService.getByID(userId));
	}
}
