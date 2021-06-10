package com.nlu.dto;

import java.util.Set;

public class SizeDTO extends BaseDTO{
	private String size;

	private Integer active;

//	private Set<InventoryDTO> inventories;

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

//	public Set<InventoryDTO> getInventories() {
//		return inventories;
//	}
//
//	public void setInventories(Set<InventoryDTO> inventories) {
//		this.inventories = inventories;
//	}
	
	
}
