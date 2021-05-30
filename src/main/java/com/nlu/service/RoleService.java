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
	
	public List<RoleEntity> getAll(){
		List<RoleEntity> roles = roleRepository.findAll();
		return roles;
	}
}
