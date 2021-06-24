package com.nlu.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nlu.dto.UserInfoDTO;
import com.nlu.entity.UserInfoEntity;
import com.nlu.repository.UserInfoRepository;

@Service
public class UserInfoService {
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public UserInfoDTO save(UserInfoDTO userInfoDTO) {
		// insert or update
		UserInfoEntity userInfoEntity = new UserInfoEntity();

		if (userInfoDTO.getId() != null) {
			UserInfoEntity oldUserInfoEntity = userInfoRepository.findById(userInfoDTO.getId().longValue());
			oldUserInfoEntity = mapper.map(userInfoDTO, UserInfoEntity.class);
			userInfoEntity = oldUserInfoEntity;
		} else {
			userInfoEntity = mapper.map(userInfoDTO, UserInfoEntity.class);
		}

		// update
		userInfoEntity = userInfoRepository.save(userInfoEntity);
		UserInfoDTO result = mapper.map(userInfoEntity, UserInfoDTO.class);

		return result;
	}
}
