package com.nlu.dto;

public class InventoryDTO  extends BaseDto{
//	private ProductDTO product;

	private SizeDTO size;

	private Integer quantity;

//	public ProductDTO getProduct() {
//		return product;
//	}
//
//	public void setProduct(ProductDTO product) {
//		this.product = product;
//	}

	public SizeDTO getSize() {
		return size;
	}

	public void setSize(SizeDTO size) {
		this.size = size;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
