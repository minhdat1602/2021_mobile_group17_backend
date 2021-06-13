package com.nlu.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class UserEntity extends BaseEntity{

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	@Column(name = "password")
	private String password;

	
	@Column(name = "code")
	private String code;


	@Column(name = "active")
	private int active;
	
	@JsonBackReference
	@OneToMany(mappedBy = "user", targetEntity = ReviewEntity.class)
	private List<ReviewEntity> reviews;

	@JsonBackReference
	@OneToMany(mappedBy = "user", targetEntity = OrderEntity.class)
	private List<OrderEntity> orders;
	
//	@JsonBackReference
//	@OneToMany(mappedBy = "staff", targetEntity = OrderEntity.class)
//	private List<OrderEntity> orders;

	@JsonBackReference
	@OneToOne(mappedBy = "user", targetEntity = CartEntity.class)
	private CartEntity cart;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<RoleEntity> roles = new HashSet<>();
	
	@JsonManagedReference
	@OneToOne(mappedBy = "user", targetEntity = UserInfoEntity.class)
	private UserInfoEntity userInfo;

	public UserEntity() {
	}

	public UserEntity(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	public UserInfoEntity getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoEntity userInfo) {
		this.userInfo = userInfo;
	}

	public List<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderEntity> orders) {
		this.orders = orders;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public List<ReviewEntity> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewEntity> reviews) {
		this.reviews = reviews;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	public Set<RoleEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RoleEntity> roles) {
		this.roles = roles;
	}

}