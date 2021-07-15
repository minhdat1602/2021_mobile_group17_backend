package com.nlu.dto;

public class OrderDetailDTO extends BaseDto {
//	private OrderDTO order;

	private double price;

	private double discount;

	private double quantity;

	private ProductDTO product;

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

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

//	public OrderDTO getOrder() {
//		return order;
//	}
//
//	public void setOrder(OrderDTO order) {
//		this.order = order;
//	}

}
