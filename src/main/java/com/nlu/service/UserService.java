package com.nlu.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.UserEntity;
import com.nlu.payload.response.UserResponse;
import com.nlu.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

	public List<UserResponse> getAll() {
		List<UserEntity> users = userRepository.findAll();

		List<UserResponse> usersResponse = new ArrayList<>();
		for (UserEntity user : users) {
			usersResponse.add(mapper.map(user, UserResponse.class));
		}
		return usersResponse;
	}

	public UserResponse getByID(long id) {
		return mapper.map(userRepository.findById(id), UserResponse.class);
	}
}
