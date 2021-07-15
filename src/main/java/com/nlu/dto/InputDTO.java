package com.nlu.dto;

import java.util.Date;
import java.util.List;

public class InputDTO extends BaseDto {
	private String code;

	private SupplierDTO supplier;

	private Date date;

	private String notes;

	private double totalPrice;

	private double totalQuantity;

	private double discount;

	private double payed;

	private double lack;

	private double status;

	private UserDTO userInit;

	private List<InputDetailDTO> inputDetails;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public SupplierDTO getSupplier() {
		return supplier;
	}

	public void setSupplier(SupplierDTO supplier) {
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

	public UserDTO getUserInit() {
		return userInit;
	}

	public void setUserInit(UserDTO userInit) {
		this.userInit = userInit;
	}

	public List<InputDetailDTO> getInputDetails() {
		return inputDetails;
	}

	public void setInputDetails(List<InputDetailDTO> inputDetails) {
		this.inputDetails = inputDetails;
	}

}
