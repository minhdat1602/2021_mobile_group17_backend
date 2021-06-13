package com.nlu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nlu.entity.UserInfoEntity;

public interface UserInfoRepository extends JpaRepository<UserInfoEntity, Long>{
	
	UserInfoEntity findById(long id);
	
	UserInfoEntity findByUserId(long userId);
	
	<S extends UserInfoEntity> S save(S entity);

}
