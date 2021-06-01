package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.RoleEntity;
import com.nlu.repository.RoleRepository;

@Service
public class RoleService {
	@Autowired
	private RoleRepository roleRepository;

	public List<RoleEntity> getAll() {
		List<RoleEntity> roles = roleRepository.findAll();
		return roles;
	}

	public RoleEntity getById(long id) {
		RoleEntity role = roleRepository.findById(id);
		return role;
	}

	public RoleEntity insert(RoleEntity roleEntity) {
		RoleEntity role = roleRepository.save(roleEntity);
		return role;
	}

	public RoleEntity update(RoleEntity roleEntity) {
		RoleEntity role = roleRepository.save(roleEntity);
		return role;
	}

	public void delete(long id) {
		roleRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			roleRepository.deleteById(id);
	}
}
