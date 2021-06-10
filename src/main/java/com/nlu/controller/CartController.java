package com.nlu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nlu.dto.CartDTO;
import com.nlu.entity.CartEntity;
import com.nlu.service.CartService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping
	public ResponseEntity<?> getCart(CartEntity cart) {
//		CartEntity result = cartService.update(cart);
		return ResponseEntity.ok(cartService.getById(1));
	}

	@PostMapping
	public ResponseEntity<?> saveCart(@RequestBody CartDTO cart) {
		CartDTO cartDTO = cartService.save(cart);
		return ResponseEntity.ok(cartDTO);
	}
}
