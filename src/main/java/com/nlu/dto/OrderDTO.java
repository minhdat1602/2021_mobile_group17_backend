package com.nlu.dto;

import java.util.List;

public class OrderDTO extends BaseDTO{
	private String code;

	private double totalSellPrice;

	private double totalDiscount;

	private double totalMoney;

	private String notes;

	private StatusDTO status;

	private CouponDTO coupon;

	private UserDTO user;
	
	private List<OrderDetailDTO> orderDetails;
	
	

//	private CustomerDTO customer;

	public List<OrderDetailDTO> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailDTO> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getTotalSellPrice() {
		return totalSellPrice;
	}

	public void setTotalSellPrice(double totalSellPrice) {
		this.totalSellPrice = totalSellPrice;
	}

	public double getTotalDiscount() {
		return totalDiscount;
	}

	public void setTotalDiscount(double totalDiscount) {
		this.totalDiscount = totalDiscount;
	}

	public double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(double totalMoney) {
		this.totalMoney = totalMoney;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public StatusDTO getStatus() {
		return status;
	}

	public void setStatus(StatusDTO status) {
		this.status = status;
	}

	public CouponDTO getCoupon() {
		return coupon;
	}

	public void setCoupon(CouponDTO coupon) {
		this.coupon = coupon;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

//	public CustomerDTO getCustomer() {
//		return customer;
//	}
//
//	public void setCustomer(CustomerDTO customer) {
//		this.customer = customer;
//	}
	
}
