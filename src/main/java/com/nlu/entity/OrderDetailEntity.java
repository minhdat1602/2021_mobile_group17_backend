package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "order_detail")
@Getter
@Setter
public class OrderDetailEntity extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;

	@Column(name = "price")
	private double price;

	@Column(name = "discount")
	private double discount;

	@Column(name = "quantity")
	private double quantity;

	@ManyToOne
	@JoinColumn(name = "inventory_id")
	private InventoryEntity inventory;

	public OrderEntity getOrder() {
		return order;
	}

}
