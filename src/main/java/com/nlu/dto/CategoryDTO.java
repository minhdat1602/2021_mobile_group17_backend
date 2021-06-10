package com.nlu.dto;

import java.util.Set;

public class CategoryDTO  extends BaseDTO{

	private Set<ProductDTO> products;

	private String code;

	private String name;


	public Set<ProductDTO> getProducts() {
		return products;
	}

	public void setProducts(Set<ProductDTO> products) {
		this.products = products;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
