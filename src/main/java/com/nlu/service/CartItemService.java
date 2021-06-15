package com.nlu.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.CartItemDTO;
import com.nlu.entity.CartEntity;
import com.nlu.entity.CartItemEntity;
import com.nlu.repository.CartItemRepository;

@Service
public class CartItemService {
	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private ModelMapper moMapper;

	public List<CartItemEntity> getAll() {
		List<CartItemEntity> cartItem = cartItemRepository.findAll();
		return cartItem;
	}

	public CartItemEntity getById(long id) {
		CartItemEntity cartItem = cartItemRepository.findById(id);
		return cartItem;
	}

	public CartItemDTO save(CartItemDTO cartItemDTO, CartEntity cartEntity) {
		CartItemEntity cartItemEntity = new CartItemEntity();

		if (cartItemDTO.getId() != 0) {
			CartItemEntity oldCartItemEntity = cartItemRepository.findById(cartItemDTO.getId().longValue());
			oldCartItemEntity = moMapper.map(cartItemDTO, CartItemEntity.class);
			cartItemEntity = oldCartItemEntity;
		} else {
			cartItemEntity = moMapper.map(cartItemDTO, CartItemEntity.class);
		}

		cartItemEntity.setCart(cartEntity);

		try {
			cartItemEntity = cartItemRepository.save(cartItemEntity);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return moMapper.map(cartItemEntity, CartItemDTO.class);
	}

	public void delete(long id) {
		cartItemRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			cartItemRepository.deleteById(id);
	}
}
