package com.nlu.payload.response;

import java.util.List;

import com.nlu.dto.UserInfoDTO;

public class JwtResponse {
	private String accessToken;
	private String tokenType = "Bearer";
	private Long id;
	private String email;
	private List<String> roles;
	private UserInfoDTO userInfo;

	public JwtResponse() {
		super();
	}

//	public JwtResponse(String accessToken, Long id, String email, List<String> roles, UserInfoDTO userInfo) {
//		this.accessToken = accessToken;
//		this.id = id;
//		this.email = email;
//		this.roles = roles;
//	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public UserInfoDTO getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfoDTO userInfo) {
		this.userInfo = userInfo;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getRoles() {
		return roles;
	}
}
