//package com.nlu.entity;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//
//@Entity
//@Table(name = "customer")
//public class CustomerEntity extends BaseEntity{
//
//	@Column(name = "code")
//	private String code;
//
//	@Column(name = "fullname")
//	private String fullname;
//
//	@Column(name = "phone")
//	private String phone;
//
//	@Column(name = "address")
//	private String address;
//
//	@Column(name = "gender")
//	private int gender;
//
//	@Column(name = "birthday")
//	private Date birthday;
//	
//	@JsonBackReference
//	@OneToOne(mappedBy = "customer", targetEntity = OrderEntity.class)
//	private OrderEntity order;
//
//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	public String getFullname() {
//		return fullname;
//	}
//
//	public void setFullname(String fullname) {
//		this.fullname = fullname;
//	}
//
//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getAddress() {
//		return address;
//	}
//
//	public void setAddress(String address) {
//		this.address = address;
//	}
//
//	public int getGender() {
//		return gender;
//	}
//
//	public void setGender(int gender) {
//		this.gender = gender;
//	}
//
//	public Date getBirthday() {
//		return birthday;
//	}
//
//	public void setBirthday(Date birthday) {
//		this.birthday = birthday;
//	}
//
//	public OrderEntity getOrder() {
//		return order;
//	}
//
//	public void setOrder(OrderEntity order) {
//		this.order = order;
//	}
//
//}
