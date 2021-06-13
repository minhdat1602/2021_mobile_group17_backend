package com.nlu.payload.request;

import java.util.Date;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.nlu.dto.UserInfoDTO;

public class SignupRequest {

	@NotBlank
	@Size(max = 50)
	@Email
	private String email;

	private Set<String> role;
	
	
	UserInfoDTO userInfo;
	
//	private String firstName;
//	private String lastName;
//	private String gender;
//	private Date birthday;
//	private String phone;
//	private String sonha;
//	private String xa;
//	private String huyen;
//	private String tinh;

	public UserInfoDTO getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoDTO userInfo) {
		this.userInfo = userInfo;
	}

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;

//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public String getGender() {
//		return gender;
//	}
//
//	public void setGender(String gender) {
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

	public Set<String> getRole() {
		return this.role;
	}

	public void setRole(Set<String> role) {
		this.role = role;
	}

//	public String getPhone() {
//		return phone;
//	}
//
//	public void setPhone(String phone) {
//		this.phone = phone;
//	}
//
//	public String getSonha() {
//		return sonha;
//	}
//
//	public void setSonha(String sonha) {
//		this.sonha = sonha;
//	}
//
//	public String getXa() {
//		return xa;
//	}
//
//	public void setXa(String xa) {
//		this.xa = xa;
//	}
//
//	public String getHuyen() {
//		return huyen;
//	}
//
//	public void setHuyen(String huyen) {
//		this.huyen = huyen;
//	}
//
//	public String getTinh() {
//		return tinh;
//	}
//
//	public void setTinh(String tinh) {
//		this.tinh = tinh;
//	}

}
