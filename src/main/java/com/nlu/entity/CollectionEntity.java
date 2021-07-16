package com.nlu.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "collection")
public class CollectionEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "active",length = 1)
	private int active;

	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "brand_id", referencedColumnName = "id")
	private BrandEntity brand;

	@JsonBackReference
	@OneToMany(mappedBy = "collection", targetEntity = ProductEntity.class)
	private Set<ProductEntity> products;
}
