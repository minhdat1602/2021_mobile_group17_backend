package com.nlu.dto;

public class TypeDTO extends BaseDto{
//	private Set<ProductDTO> products;

	private String name;

	private Integer active;

//	public Set<ProductDTO> getProducts() {
//		return products;
//	}
//
//	public void setProducts(Set<ProductDTO> products) {
//		this.products = products;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}
	
}
