package com.nlu.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.nlu.common.ERole;

@Entity
@Table(name = "role")
public class RoleEntity extends BaseEntity {

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private ERole code;

	@Column
	private String name;

	public RoleEntity() {
	}

	@ManyToMany(mappedBy = "roles")
	private Set<UserEntity> users = new HashSet<>();

	public RoleEntity(ERole code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ERole getCode() {
		return code;
	}

	public void setName(ERole code) {
		this.code = code;
	}
}
