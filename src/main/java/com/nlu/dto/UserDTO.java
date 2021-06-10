package com.nlu.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserDTO extends BaseDTO {
	private String email;

	private String firstName;

	private String lastName;

	private String code;

	private String gender;

	private String phone;

	private String address;

	private Date birthday;

	private int active;

//	private List<ReviewDTO> reviews;
//
//	private List<OrderDTO> orders;

//	private CartDTO cart;

//	private Set<RoleDTO> roles = new HashSet<>();

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

//	public List<ReviewDTO> getReviews() {
//		return reviews;
//	}
//
//	public void setReviews(List<ReviewDTO> reviews) {
//		this.reviews = reviews;
//	}
//
//	public List<OrderDTO> getOrders() {
//		return orders;
//	}
//
//	public void setOrders(List<OrderDTO> orders) {
//		this.orders = orders;
//	}

//	public CartDTO getCart() {
//		return cart;
//	}
//
//	public void setCart(CartDTO cart) {
//		this.cart = cart;
//	}

//	public Set<RoleDTO> getRoles() {
//		return roles;
//	}
//
//	public void setRoles(Set<RoleDTO> roles) {
//		this.roles = roles;
//	}

}
