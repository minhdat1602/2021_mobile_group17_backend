package com.nlu.dto;

public class StatusDTO extends BaseDTO{
	private String code;

	private String name;

	private int active;

//	private List<OrderDTO> orders;

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

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

//	public List<OrderDTO> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<OrderDTO> orders) {
//		this.orders = orders;
//	}

}
