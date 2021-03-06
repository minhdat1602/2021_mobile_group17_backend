package com.nlu.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "size")
public class SizeEntity extends BaseEntity{

	@Column(name = "size")
	private String size;

	@Column(name = "active", length = 2)
	private Integer active;

	@JsonBackReference
	@OneToMany(mappedBy = "size", targetEntity = InventoryEntity.class)
	private Set<InventoryEntity> inventories;

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

	public Set<InventoryEntity> getInventories() {
		return inventories;
	}

	public void setInventories(Set<InventoryEntity> inventories) {
		this.inventories = inventories;
	}

}
