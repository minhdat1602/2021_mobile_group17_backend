package com.nlu.dto;

public class InputDetailDTO  extends BaseDTO{
//	private InputDTO input;

	private int quantity;

	private ProductDTO product;

	private double price;

//	public InputDTO getInput() {
//		return input;
//	}
//
//	public void setInput(InputDTO input) {
//		this.input = input;
//	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
