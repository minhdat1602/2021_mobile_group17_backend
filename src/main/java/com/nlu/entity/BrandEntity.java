package com.nlu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "brand")
public class BrandEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "active")
	private int active;

	@JsonManagedReference
	@OneToMany(mappedBy = "brand")
	private List<CollectionEntity> collections;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public List<CollectionEntity> getCollections() {
		return collections;
	}

	public void setCollections(List<CollectionEntity> collections) {
		this.collections = collections;
	}

}
