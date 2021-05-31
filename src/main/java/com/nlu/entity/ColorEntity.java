package com.nlu.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "color")
public class ColorEntity extends BaseEntity{
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "active")
	private Integer active;
	
//	@JsonBackReference
//	@OneToMany(mappedBy = "color")
//	private Set<StockEntity> stocks;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

//	public Set<StockEntity> getStocks() {
//		return stocks;
//	}
//
//	public void setStocks(Set<StockEntity> stocks) {
//		this.stocks = stocks;
//	}
	
	
}
