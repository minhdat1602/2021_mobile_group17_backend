package com.nlu.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "user_info")
public class UserInfoEntity extends BaseEntity{

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "gender")
	private String gender;

	@Column(name = "phone")
	private String phone;

	@Column(name = "birthday")
	private Date birthday;

	@Column(name = "sonha")
	private String sonha;

	@Column(name = "xa")
	private String xa;

	@Column(name = "huyen")
	private String huyen;

	@Column(name = "tinh")
	private String tinh;
	
	@JsonBackReference
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private UserEntity user;

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSonha() {
		return sonha;
	}

	public void setSonha(String sonha) {
		this.sonha = sonha;
	}

	public String getXa() {
		return xa;
	}

	public void setXa(String xa) {
		this.xa = xa;
	}

	public String getHuyen() {
		return huyen;
	}

	public void setHuyen(String huyen) {
		this.huyen = huyen;
	}

	public String getTinh() {
		return tinh;
	}

	public void setTinh(String tinh) {
		this.tinh = tinh;
	}

}
