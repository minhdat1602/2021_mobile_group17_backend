package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.CartEntity;
import com.nlu.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	public List<CartEntity> getAll() {
		List<CartEntity> cart = cartRepository.findAll();
		return cart;
	}

	public CartEntity getById(long id) {
		CartEntity cart = cartRepository.findById(id);
		return cart;
	}

	public CartEntity insert(CartEntity cartEntity) {
		CartEntity cart = cartRepository.save(cartEntity);
		return cart;
	}

	public CartEntity update(CartEntity cartEntity) {
		CartEntity cart = cartRepository.save(cartEntity);
		return cart;
	}

	public void delete(long id) {
		cartRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			cartRepository.deleteById(id);
	}
}
