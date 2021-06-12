package com.nlu.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.UserDTO;
import com.nlu.entity.UserEntity;
import com.nlu.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper mapper;

//	public List<UserResponse> getAll() {
//		List<UserEntity> users = userRepository.findAll();
//
//		List<UserResponse> usersResponse = new ArrayList<>();
//		for (UserEntity user : users) {
//			usersResponse.add(mapper.map(user, UserResponse.class));
//		}
//		return usersResponse;
//	}

	public UserDTO getByID(long id) {
		return mapper.map(userRepository.findById(id), UserDTO.class);
	}
	
	public UserEntity insert(UserEntity userEntity) {
		UserEntity user = userRepository.save(userEntity);
		return user;
	}

	public UserEntity update(UserEntity userEntity) {
		UserEntity user = userRepository.save(userEntity);
		return user;
	}

	public void delete(long id) {
		userRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			userRepository.deleteById(id);
	}
}
