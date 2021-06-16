package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "order_detail")
public class OrderDetailEntity extends BaseEntity{
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;

	@Column(name = "price")
	private double price;

	@Column(name = "discount")
	private double discount;

	@Column(name = "quantity")
	private double quantity;

//	@JsonManagedReference
//	@ManyToOne
//	@JoinColumn(name = "inventory_id", referencedColumnName = "id")
//	private InventoryEntity inventory;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductEntity product;

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

//	public InventoryEntity getInventory() {
//		return inventory;
//	}
//
//	public void setInventory(InventoryEntity inventory) {
//		this.inventory = inventory;
//	}
	

}
