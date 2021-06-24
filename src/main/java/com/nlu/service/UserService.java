package com.nlu.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.UserDTO;
import com.nlu.dto.UserInfoDTO;
import com.nlu.entity.UserEntity;
import com.nlu.entity.UserInfoEntity;
import com.nlu.repository.UserInfoRepository;
import com.nlu.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
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
	
	public UserDTO save(UserDTO userDTO) {
		
		//insert or update
		UserEntity userEntity = new UserEntity();
		
		if(userDTO.getId() != null) {
			UserEntity oldUserEntity = userRepository.findById(userDTO.getId().longValue());
			oldUserEntity = mapper.map(userDTO, UserEntity.class);
			userEntity = oldUserEntity;
		}else {
			userEntity = mapper.map(userDTO, UserEntity.class);
		}
		
		//update userInfo
		UserInfoEntity userInfoEntity = mapper.map(userDTO.getUserInfo(),UserInfoEntity.class);
		
		UserInfoEntity oldUserInfoEntity = userInfoRepository.findById(userDTO.getUserInfo().getId().longValue());
		oldUserInfoEntity = userInfoEntity;
		oldUserInfoEntity.setUser(userEntity);
		userInfoEntity = userInfoRepository.save(oldUserInfoEntity);
		
		//update
		userEntity = userRepository.save(userEntity);
		UserDTO result = mapper.map(userEntity, UserDTO.class);
		result.setUserInfo(mapper.map(userInfoEntity, UserInfoDTO.class));
		
		
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
