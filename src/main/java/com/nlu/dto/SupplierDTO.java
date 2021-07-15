package com.nlu.dto;

import java.util.List;

public class SupplierDTO extends BaseDto{
	private String code;

	private String name;

	private String phone;

	private String email;

	private String address;

	private String taxcode;

	private List<InputDTO> input;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTaxcode() {
		return taxcode;
	}

	public void setTaxcode(String taxcode) {
		this.taxcode = taxcode;
	}

	public List<InputDTO> getInput() {
		return input;
	}

	public void setInput(List<InputDTO> input) {
		this.input = input;
	}

}
