package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "cart_item")
public class CartItemEntity extends BaseEntity{

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private CartEntity cart;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "inventory_id", referencedColumnName = "id")
	private InventoryEntity inventory;

	@Column(name = "quantity")
	private Integer quantity;

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	public InventoryEntity getInventory() {
		return inventory;
	}

	public void setInventory(InventoryEntity inventory) {
		this.inventory = inventory;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

}
