package com.nlu.dto;

public class TopUser {
	UserDTO user;
	long totalPrice;
	long buyNum;

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(long buyNum) {
		this.buyNum = buyNum;
	}

}
