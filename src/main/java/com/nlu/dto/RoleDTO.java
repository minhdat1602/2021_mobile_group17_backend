package com.nlu.dto;

import java.util.HashSet;
import java.util.Set;

import com.nlu.common.ERole;

public class RoleDTO extends BaseDto{
	private ERole code;

	private String name;

	private Set<UserDTO> users = new HashSet<>();

	public ERole getCode() {
		return code;
	}

	public void setCode(ERole code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(Set<UserDTO> users) {
		this.users = users;
	}
	
	
}
