package com.nlu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "brand")
public class BrandEntity extends BaseEntity {

	@Column(name = "name")
	private String name;

	@Column(name = "active", length = 2)
	private int active;

	@JsonManagedReference
	@OneToMany(mappedBy = "brand")
	private List<CollectionEntity> collections;

}
