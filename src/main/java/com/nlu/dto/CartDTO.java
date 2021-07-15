package com.nlu.dto;

import java.util.List;

public class CartDTO  extends BaseDto{
	private UserDTO user;
	private List<CartItemDTO> cartItems;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public List<CartItemDTO> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItemDTO> cartItems) {
		this.cartItems = cartItems;
	}

}
