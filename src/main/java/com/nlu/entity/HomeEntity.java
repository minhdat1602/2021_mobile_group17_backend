package com.nlu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name="home")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class HomeEntity extends BaseEntity{
	
	@Column(name="name")
	private String name;
	@Column(name="area")
	private Integer area;
	@Column(name="bedroom")
	private Integer bedroom;
	@Column(name="bathroom")
	private Integer bathroom;
	@Column(name="direct")
	private String direct;
	@Column(name="price")
	private Integer price;
	@Column(name="image")
	private String image;
	@Column(name="hot")
	private Integer hot;
	@Column(name="highlight")
	private Integer highlight;
	@Column(name="active")
	private Integer active;
}
