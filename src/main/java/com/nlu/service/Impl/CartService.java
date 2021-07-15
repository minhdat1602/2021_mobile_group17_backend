package com.nlu.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.CartDTO;
import com.nlu.dto.CartItemDTO;
import com.nlu.entity.CartEntity;
import com.nlu.repository.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private ModelMapper moMapper;

	public List<CartEntity> getAll() {
		List<CartEntity> cart = cartRepository.findAll();
		return cart;
	}

	public CartEntity getById(long id) {
		CartEntity cart = cartRepository.findById(id);
		return cart;
	}

	public CartDTO save(CartDTO cartDTO) {
		CartEntity cartEntity = new CartEntity();

		// Nếu cart có id là null, sẽ tạo mới cart -> insert
		// Nếu cart có id khác null, lấy cart lên và thay đổi -> update
		if (cartDTO.getId() != 0) {
			CartEntity oldCartEntity = cartRepository.findById(cartDTO.getId().longValue());
			oldCartEntity = moMapper.map(cartDTO, CartEntity.class);
			cartEntity = oldCartEntity;
		} else {
			cartEntity = moMapper.map(cartDTO, CartEntity.class);
		}

		// update, insert cho cart items
		List<CartItemDTO> cartItemDTOs = new ArrayList<CartItemDTO>(); // ds sau khi insert, update
		for (int i = 0; i < cartDTO.getCartItems().size(); i++) {
			CartItemDTO cartItemDTO = cartDTO.getCartItems().get(i);
			cartItemDTOs.add(cartItemService.save(cartItemDTO, cartEntity));
		}
		// insert, update cho cart
		try {
			cartEntity = cartRepository.save(cartEntity);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		CartDTO result = moMapper.map(cartEntity, CartDTO.class); // cart trả về sau khi insert, update
		result.setCartItems(cartItemDTOs); // set ds cart items sau khi insert update cho cart.

		return result;
	}

	public void delete(long id) {
		cartRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			cartRepository.deleteById(id);
	}
}
