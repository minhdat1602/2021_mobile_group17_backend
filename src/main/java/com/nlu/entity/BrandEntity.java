package com.nlu.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "brand")
@Getter
@Setter
public class BrandEntity extends BaseEntity {

	@Column(name = "brand_name")
	private String name;

	@Column(name = "active")
	private int active;

	@JsonBackReference
	@OneToMany(mappedBy = "brand")
	private Set<CollectionEntity> collections;
}
