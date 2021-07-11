package com.nlu.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.entity.UserInfoEntity;
import com.nlu.repository.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private UserInfoRepository userInfoRepository;

	public UserInfoEntity save(UserInfoEntity userInfoEntity) {

		UserInfoEntity result = new UserInfoEntity();
		if (userInfoEntity.getId() != null) {
			UserInfoEntity oldUserInfoEntity = userInfoRepository.findById(userInfoEntity.getId().longValue());
			oldUserInfoEntity = mapper.map(userInfoEntity, UserInfoEntity.class);
			result = oldUserInfoEntity;
		} else {
			result = mapper.map(userInfoEntity, UserInfoEntity.class);
		}

		result = userInfoRepository.save(result);
		return result;
	}
}
