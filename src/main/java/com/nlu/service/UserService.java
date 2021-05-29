package com.nlu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.UserEntity;
import com.nlu.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<UserEntity> getAll() {
		return userRepository.findAll();
	}

	public UserEntity getByID(long id) {
		return userRepository.findById(id);
	}
}
