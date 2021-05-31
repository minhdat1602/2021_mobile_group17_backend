package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_item")
@Getter
@Setter
public class CartItemEntity extends BaseEntity {

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private CartEntity cart;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private InventoryEntity inventory;

	@Column(name = "quantity")
	private Integer quantity;


}
