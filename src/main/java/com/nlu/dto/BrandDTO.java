package com.nlu.dto;

import java.util.List;

public class BrandDTO extends BaseDTO{
	
	private String name;
	
	private List<CollectionDTO> collections;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CollectionDTO> getCollections() {
		return collections;
	}
	public void setCollections(List<CollectionDTO> collections) {
		this.collections = collections;
	}
	
}
