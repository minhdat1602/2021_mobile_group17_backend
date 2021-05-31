package com.nlu.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "input")
@Getter
@Setter
public class InputEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@ManyToOne
	@JoinColumn(name = "supplier_id")
	private SupplierEntity supplier;

	@Column(name = "input_date")
	private Date date;

	@Column(name = "notes")
	private String notes;

	@Column(name = "total_price")
	private double totalPrice;

	@Column(name = "total_Quantity")
	private double totalQuantity;

	@Column(name = "discout")
	private double discount;

	@Column(name = "payed")
	private double payed;

	@Column(name = "lack")
	private double lack;

	@Column(name = "input_status")
	private double status;

	@Column(name = "user_init")
	private UserEntity userInit;

	@JsonManagedReference
	@OneToMany(mappedBy = "input")
	private List<InputDetailEntity> inputDetails;

}
