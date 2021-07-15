package com.nlu.dto;

public class CartItemDTO  extends BaseDto{
	private int quantity;
	private InventoryDTO inventory;
//	private CartDTO cart;
//	
//	public CartDTO getCart() {
//		return cart;
//	}
//
//	public void setCart(CartDTO cart) {
//		this.cart = cart;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public InventoryDTO getInventory() {
		return inventory;
	}

	public void setInventory(InventoryDTO inventory) {
		this.inventory = inventory;
	}

}
