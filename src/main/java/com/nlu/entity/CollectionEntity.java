package com.nlu.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "collection")
@Getter
@Setter
public class CollectionEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "code")
	private String code;

	@Column(name = "active")
	private String active;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "brand_id")
	private BrandEntity brand;

	@JsonBackReference
	@OneToMany(mappedBy = "collection")
	private Set<ProductEntity> products;

}
