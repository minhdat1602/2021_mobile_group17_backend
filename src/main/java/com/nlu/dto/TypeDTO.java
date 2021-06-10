package com.nlu.dto;

import java.util.Set;

public class TypeDTO extends BaseDTO{
	private Set<ProductDTO> products;

	private String name;

	private Integer active;

	public Set<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDTO> products) {
		this.products = products;
	}

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
