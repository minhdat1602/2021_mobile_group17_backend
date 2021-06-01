package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.CartItemEntity;
import com.nlu.repository.CartItemRepository;

@Service
public class CartItemService {
	@Autowired
	private CartItemRepository cartItemRepository;

	public List<CartItemEntity> getAll() {
		List<CartItemEntity> cartItem = cartItemRepository.findAll();
		return cartItem;
	}

	public CartItemEntity getById(long id) {
		CartItemEntity cartItem = cartItemRepository.findById(id);
		return cartItem;
	}

	public CartItemEntity insert(CartItemEntity cartItemEntity) {
		CartItemEntity cartItem = cartItemRepository.save(cartItemEntity);
		return cartItem;
	}

	public CartItemEntity update(CartItemEntity cartItemEntity) {
		CartItemEntity cartItem = cartItemRepository.save(cartItemEntity);
		return cartItem;
	}

	public void delete(long id) {
		cartItemRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			cartItemRepository.deleteById(id);
	}
}
