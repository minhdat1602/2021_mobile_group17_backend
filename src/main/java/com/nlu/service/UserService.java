package com.nlu.service;

import java.util.ArrayList;
import java.util.List;

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

	public List<UserDTO> getAll() {
		List<UserEntity> userEntities = userRepository.findAll();
		List<UserDTO> result = new ArrayList<UserDTO>();
		for (UserEntity entity : userEntities) {
			result.add(mapper.map(entity, UserDTO.class));
		}
		return result;
	}

	public UserDTO getByID(long id) {
		return mapper.map(userRepository.findById(id), UserDTO.class);
	}

	public UserEntity save(UserEntity userEntity) {

		// insert or update
		UserEntity result = new UserEntity();

		if (userEntity.getId() != null) {
			UserEntity oldUserEntity = userRepository.findById(userEntity.getId().longValue());
			oldUserEntity = mapper.map(userEntity, UserEntity.class);
			result = oldUserEntity;
		} else {
			result = mapper.map(userEntity, UserEntity.class);
		}

		// update, insert
		result = userRepository.save(userEntity);

		// update userInfoEntity

		return result;
	}

	public void delete(long id) {
		userRepository.deleteById(id);
	}

	public void deleteAll(long[] ids) {
		for (long id : ids)
			userRepository.deleteById(id);
	}
}
