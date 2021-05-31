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

@Entity
@Table(name = "input")
public class InputEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@JsonManagedReference
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

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "user_init", referencedColumnName = "id")
	private UserEntity userInit;

	@JsonManagedReference
	@OneToMany(mappedBy = "input", targetEntity = InputDetailEntity.class)
	private List<InputDetailEntity> inputDetails;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public SupplierEntity getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierEntity supplier) {
		this.supplier = supplier;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public double getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(double totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getPayed() {
		return payed;
	}

	public void setPayed(double payed) {
		this.payed = payed;
	}

	public double getLack() {
		return lack;
	}

	public void setLack(double lack) {
		this.lack = lack;
	}

	public double getStatus() {
		return status;
	}

	public void setStatus(double status) {
		this.status = status;
	}

	public UserEntity getUserInit() {
		return userInit;
	}

	public void setUserInit(UserEntity userInit) {
		this.userInit = userInit;
	}

	public List<InputDetailEntity> getInputDetails() {
		return inputDetails;
	}

	public void setInputDetails(List<InputDetailEntity> inputDetails) {
		this.inputDetails = inputDetails;
	}

}
