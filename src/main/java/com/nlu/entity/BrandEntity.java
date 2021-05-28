package com.nlu.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "brand")
public class BrandEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@JsonBackReference
	@OneToMany(mappedBy = "collectionBrand",fetch = FetchType.LAZY)
	private Set<CollectionEntity> collections;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<CollectionEntity> getCollections() {
		return collections;
	}

	public void setCollections(Set<CollectionEntity> collections) {
		this.collections = collections;
	}
	
}
