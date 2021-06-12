package com.nlu.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity {

	@Column(name = "code")
	private String code;

	@Column(name = "total_origin_price")
	private double totalSellPrice;

	@Column(name = "total_discount")
	private double totalDiscount;

	@Column(name = "total_money")
	private double totalMoney;

	@Column(name = "notes")
	private String notes;

	@JsonManagedReference
	@OneToMany(mappedBy = "order", targetEntity = OrderDetailEntity.class)
	private List<OrderDetailEntity> orderDetails;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "order_status_id", referencedColumnName = "id")
	private StatusEntity status;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "coupon_id", referencedColumnName = "id")
	private CouponEntity coupon;

	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity user;

//	@JsonManagedReference
//	@OneToOne
//	@JoinColumn(name = "staff_id", referencedColumnName = "id")
//	private UserEntity staff;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<OrderDetailEntity> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetailEntity> orderDetails) {
		this.orderDetails = orderDetails;
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

	public StatusEntity getStatus() {
		return status;
	}

	public void setStatus(StatusEntity status) {
		this.status = status;
	}

	public CouponEntity getCoupon() {
		return coupon;
	}

	public void setCoupon(CouponEntity coupon) {
		this.coupon = coupon;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
//
//	public UserEntity getStart() {
//		return staff;
//	}
//
//	public void setStart(UserEntity start) {
//		this.staff = start;
//	}

}
